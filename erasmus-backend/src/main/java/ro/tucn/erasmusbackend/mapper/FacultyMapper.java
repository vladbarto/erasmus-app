package ro.tucn.erasmusbackend.mapper;

import org.mapstruct.Mapper;
import ro.tucn.erasmusbackend.dto.faculty.FacultyRequestDTO;
import ro.tucn.erasmusbackend.dto.faculty.FacultyResponseDTO;
import ro.tucn.erasmusbackend.model.FacultyEntity;

import java.util.List;

@Mapper
public interface FacultyMapper {
    FacultyResponseDTO facultyEntityToFacultyResponseDTO(FacultyEntity facultyEntity);

    List<FacultyResponseDTO> facultyEntityListToFacultyResponseDTOList(List<FacultyEntity> facultyEntityList);

    FacultyEntity facultyRequestDTOToFacultyEntity(FacultyRequestDTO facultyRequestDTO);
}
