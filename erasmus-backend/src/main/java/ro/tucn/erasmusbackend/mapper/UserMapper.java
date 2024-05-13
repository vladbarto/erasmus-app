package ro.tucn.erasmusbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ro.tucn.erasmusbackend.dto.user.UserRequestDTO;
import ro.tucn.erasmusbackend.dto.user.UserResponseDTO;
import ro.tucn.erasmusbackend.model.UserEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserResponseDTO userEntityToUserResponseDTO(UserEntity userEntity);

    UserEntity userRequestDTOToUserEntity(UserRequestDTO userRequestDTO);
}
