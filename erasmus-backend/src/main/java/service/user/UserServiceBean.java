package service.user;

import dto.username.UserResponseDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserServiceBean implements UserService{
    @Override
    public List<UserResponseDTO> findAll() {
        return null;
    }
}
