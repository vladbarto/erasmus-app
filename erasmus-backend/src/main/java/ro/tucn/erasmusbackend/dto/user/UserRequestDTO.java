package ro.tucn.erasmusbackend.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Necessary for user registration
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    private String email;
    private String username;
    private String password;
    private RoleDTO role;
}
