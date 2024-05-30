package ro.tucn.erasmusbackend.service.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import ro.tucn.erasmusbackend.dto.user.UserRequestDTO;
import ro.tucn.erasmusbackend.dto.user.UserResponseDTO;
import ro.tucn.erasmusbackend.exception.ExceptionCode;
import ro.tucn.erasmusbackend.exception.NotFoundException;
import ro.tucn.erasmusbackend.mapper.UserMapper;
import ro.tucn.erasmusbackend.model.UserEntity;
import ro.tucn.erasmusbackend.repository.UserRepository;
import ro.tucn.erasmusbackend.security.util.SecurityConstants;

@Slf4j
@RequiredArgsConstructor
public class UserServiceBean implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDTO findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(userMapper::entityToResponseDTO)
                .orElseThrow(() -> new NotFoundException(String.format(
                        ExceptionCode.ERR002_USERNAME_NOT_FOUND.getMessage(),
                        username
                )));
    }

    @Override
    @Transactional
    public UserResponseDTO save(UserRequestDTO userRequestDTO) {
        UserEntity userToBeAdded = userMapper.requestDTOToEntity(userRequestDTO);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(SecurityConstants.PASSWORD_STRENGTH);
        userToBeAdded.setPassword(passwordEncoder.encode(userToBeAdded.getPassword()));//TODO

        UserEntity userAdded = userRepository.save(userToBeAdded);

        return userMapper.entityToResponseDTO(userAdded);
    }
}