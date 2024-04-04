package ro.tucn.erasmusbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import ro.tucn.erasmusbackend.dto.faculty.FacultyRequestDTO;
import ro.tucn.erasmusbackend.dto.faculty.FacultyResponseDTO;
import ro.tucn.erasmusbackend.mapper.FacultyMapper;
import ro.tucn.erasmusbackend.model.FacultyEntity;
import ro.tucn.erasmusbackend.repository.FacultyRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class FacultyServiceBean implements FacultyService {
    private final FacultyRepository facultyRepository;
    private final FacultyMapper facultyMapper;
    private final String applicationName;

    @Override
    public List<FacultyResponseDTO> findAll() {
        log.info("Getting all chefs for application {}", applicationName);

        List<FacultyEntity> facultyEntityList = facultyRepository.findAll();

        return facultyMapper.facultyEntityListToFacultyResponseDTOList(facultyEntityList);
    }

    @Override
    @Transactional
    public FacultyResponseDTO save(FacultyRequestDTO facultyRequestDTO) {
        FacultyEntity facultyToBeAdded = facultyMapper.facultyRequestDTOToFacultyEntity(facultyRequestDTO);
        FacultyEntity facultyAdded = facultyRepository.save(facultyToBeAdded);

        return facultyMapper.facultyEntityToFacultyResponseDTO(facultyAdded);
    }
}
