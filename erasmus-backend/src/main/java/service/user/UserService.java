package service.user;

import dto.username.UserResponseDTO;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> findAll();
}
