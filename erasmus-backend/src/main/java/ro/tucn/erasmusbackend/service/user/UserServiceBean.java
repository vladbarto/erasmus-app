package ro.tucn.erasmusbackend.service.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import ro.tucn.erasmusbackend.dto.user.UserResponseDTO;
import ro.tucn.erasmusbackend.exception.ExceptionCode;
import ro.tucn.erasmusbackend.exception.NotFoundException;
import ro.tucn.erasmusbackend.mapper.UserMapper;
import ro.tucn.erasmusbackend.repository.UserRepository;

@Slf4j
@RequiredArgsConstructor
public class UserServiceBean implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDTO findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(userMapper::userEntityToUserResponseDTO)
                .orElseThrow(() -> new NotFoundException(String.format(
                        ExceptionCode.ERR002_USERNAME_NOT_FOUND.getMessage(),
                        username
                )));
    }
}
