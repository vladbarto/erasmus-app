package ro.tucn.erasmusbackend.service.user;

import ro.tucn.erasmusbackend.dto.user.UserRequestDTO;
import ro.tucn.erasmusbackend.dto.user.UserResponseDTO;


public interface UserService {

    UserResponseDTO findByUsername(String username);
    UserResponseDTO save(UserRequestDTO userRequestDTO);
}


