package ro.tucn.erasmusbackend.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import ro.tucn.erasmusbackend.exception.ExceptionBody;
import ro.tucn.erasmusbackend.security.util.JwtUtil;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Slf4j
@RequiredArgsConstructor
public class AuthorizationFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        String jwtToken = JwtUtil.getTokenFromRequest(request);
        if (jwtToken == null) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            Claims claims = (Claims) Jwts.parser()
                    .verifyWith((SecretKey) JwtUtil.getSigningKey(JwtUtil.secretKey))
                    .build()
                    .parse(jwtToken)
                    .getPayload();
            String email = claims.getSubject();
            Collection<SimpleGrantedAuthority> authorities = ((List<String>) claims.get("role")).stream()
                    .map(SimpleGrantedAuthority::new)
                    .toList();
            Authentication authentication = new UsernamePasswordAuthenticationToken(email, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            filterChain.doFilter(request, response);
        } catch (Exception exception) {
            this.onUnsuccessfulAuthorization(response, exception.getMessage());
        }
    }

    private void onUnsuccessfulAuthorization(HttpServletResponse response, String message) {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.FORBIDDEN.value());

        try {
            objectMapper.writeValue(response.getWriter(), new ExceptionBody(message));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}