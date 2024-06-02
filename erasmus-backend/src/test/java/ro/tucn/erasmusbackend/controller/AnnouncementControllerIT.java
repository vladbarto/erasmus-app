package ro.tucn.erasmusbackend.controller;

import io.swagger.v3.oas.models.PathItem;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementResponseDTO;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static ro.tucn.erasmusbackend.mapper.AnnouncementMapperTest.REPRESENTATIVE_ID;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AnnouncementControllerIT {
    private static String API_URL = "http://localhost:{PORT}/api/announcement/v1";

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private Integer port;

    @Value("${security.invalid-jwt-token}")
    private String invalidJwtToken;

    @Value("${security.admin-jwt-token}")
    private String adminJwtToken;

    @BeforeEach
    public void setUp() { API_URL = API_URL.replace("{PORT}", port.toString()); }

    @Test
    @DisplayName(value = "For invalid token return status Forbidden")
    void givenInvalidJwtToken_whenFindByIdIsCalled_thenReturnAccessForbidden() {
        final var announcementId = UUID.fromString("00000000-0000-0000-0000-000000000000");
        final var headers = getHeadersEntity(invalidJwtToken);

        final var response = testRestTemplate.exchange(
                String.format("%s/%s", API_URL, announcementId),
                HttpMethod.GET,
                headers,
                AnnouncementResponseDTO.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);
    }

    @Test
    @DisplayName(value = "For valid announcement id return annpuncement reponse dto")
    void givenValidAnnouncementId_whenFindByIdIsCalled_thenReturnAnnouncementResponseDTO() {
        final var announcementId = UUID.fromString("00000000-0000-0000-0000-000000000000");
        final var headers = getHeadersEntity(adminJwtToken);
        final var expected = getAnnouncementResponseDTO();

        final var response = testRestTemplate.exchange(
                String.format("%s/%s", API_URL, announcementId),
                HttpMethod.GET,
                headers,
                AnnouncementResponseDTO.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(expected);
    }

    @Test
    @DisplayName(value = "For invalid (or inexistent) announcement id throw exception and status not found")
    void givenInvalidAnnouncementId_whenFindByIdIsCalled_thenThrowException() {
        final var announcementId = UUID.fromString("99999999-9999-9999-9999-999999999999");
        final var headers = getHeadersEntity(adminJwtToken);

        final var response = testRestTemplate.exchange(
                String.format("%s/%s", API_URL, announcementId),
                HttpMethod.GET,
                headers,
                AnnouncementResponseDTO.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    private HttpEntity<?> getHeadersEntity(String jwtToken) {
        final var headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + jwtToken);

        return new HttpEntity<>(null, headers);
    }

    private AnnouncementResponseDTO getAnnouncementResponseDTO() {
        return AnnouncementResponseDTO.builder()
                .announcementId(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                .title("Stiri Erasmus")
                .description("S-a publicat lista cu studentii admisi.")
                .representativeId(REPRESENTATIVE_ID)
                .universityCode("UTCN_01")
                .build();
    }
}
