package ro.tucn.erasmusbackend.service.user;

import ro.tucn.erasmusbackend.dto.user.UserResponseDTO;

public interface UserService {

    UserResponseDTO findByUsername(String username);
}


