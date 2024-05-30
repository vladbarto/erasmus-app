package ro.tucn.erasmusbackend.service.faculty;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import ro.tucn.erasmusbackend.dto.faculty.FacultyRequestDTO;
import ro.tucn.erasmusbackend.dto.faculty.FacultyResponseDTO;
import ro.tucn.erasmusbackend.mapper.FacultyMapper;
import ro.tucn.erasmusbackend.model.FacultyEntity;
import ro.tucn.erasmusbackend.repository.FacultyRepository;

import ro.tucn.erasmusbackend.exception.NotFoundException;
import ro.tucn.erasmusbackend.exception.ExceptionCode;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

        return facultyMapper.entityListToResponseDTOList(facultyEntityList);
    }

    @Override
    public FacultyResponseDTO findById(UUID facultyId) {
        return facultyRepository.findById(facultyId)
                .map(facultyMapper::entityToResponseDTO)
                .orElseThrow(() -> new NotFoundException(String.format(
                        ExceptionCode.ERR001_FACULTY_NOT_FOUND.getMessage(),
                        facultyId
                )));
    }

    @Override
    @Transactional
    public FacultyResponseDTO save(FacultyRequestDTO facultyRequestDTO) {
        log.info("Saving (Posting) a faculty for application {}", applicationName);
        FacultyEntity facultyToBeAdded = facultyMapper.requestDTOToEntity(facultyRequestDTO);
        FacultyEntity facultyAdded = facultyRepository.save(facultyToBeAdded);

        return facultyMapper.entityToResponseDTO(facultyAdded);
    }

    @Override
    public FacultyResponseDTO update(FacultyRequestDTO facultyRequestDTO, UUID facultyId) {
        return facultyRepository.findById(facultyId)
                .map((facultyEntity)-> {
                    facultyEntity.setCompositeKey(facultyRequestDTO.getCompositeKey());
                    facultyEntity.setName(facultyRequestDTO.getName());
                    facultyEntity.setDescription(facultyRequestDTO.getDescription());
                    facultyEntity.setUniversityCode(facultyRequestDTO.getUniversityCode());

                    facultyRepository.save(facultyEntity);

                    return facultyEntity;
                })
                .map(facultyMapper::entityToResponseDTO)
                .orElseThrow(() -> new NotFoundException(String.format(
                        ExceptionCode.ERR001_FACULTY_NOT_FOUND.getMessage(),
                        facultyId
                )))
                ;
    }

    @Override
    public FacultyResponseDTO deleteById(UUID facultyId) {
        List<UUID> ids = new ArrayList<>();
        ids.add(facultyId);

        facultyRepository.deleteAllByIdInBatch(ids);
        return facultyRepository.findById(facultyId)
                .map(facultyMapper::entityToResponseDTO)
                .orElseThrow(() -> new NotFoundException(String.format(
                        ExceptionCode.ERR001_FACULTY_NOT_FOUND.getMessage(),
                        facultyId
                )));
    }

}
