package ro.tucn.erasmusbackend.service.uniqueSubject;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import ro.tucn.erasmusbackend.dto.uniqueSubject.UniqueSubjectRequestDTO;
import ro.tucn.erasmusbackend.dto.uniqueSubject.UniqueSubjectResponseDTO;
import ro.tucn.erasmusbackend.dto.uniqueSubject.UniqueSubjectRequestDTO;
import ro.tucn.erasmusbackend.dto.uniqueSubject.UniqueSubjectResponseDTO;
import ro.tucn.erasmusbackend.exception.ExceptionCode;
import ro.tucn.erasmusbackend.exception.NotFoundException;
import ro.tucn.erasmusbackend.mapper.UniqueSubjectMapper;
import ro.tucn.erasmusbackend.model.UniqueSubjectEntity;
import ro.tucn.erasmusbackend.repository.UniqueSubjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class UniqueSubjectServiceBean implements UniqueSubjectService {
    private final UniqueSubjectRepository uniqueSubjectRepository;
    private final UniqueSubjectMapper uniqueSubjectMapper;
    private final String applicationName;

    @Override
    public List<UniqueSubjectResponseDTO> findAll() {
        log.info("Getting all unique-subjects for application {}", applicationName);

        List<UniqueSubjectEntity> uniqueSubjectEntityList = uniqueSubjectRepository.findAll();

        return uniqueSubjectMapper.uniqueSubjectEntityListToUniqueSubjectResponseDTOList(uniqueSubjectEntityList);
    }

    @Override
    @Transactional
    public UniqueSubjectResponseDTO save(UniqueSubjectRequestDTO uniqueSubjectRequestDTO) {
        UniqueSubjectEntity uniqueSubjectToBeAdded = uniqueSubjectMapper.uniqueSubjectRequestDTOToUniqueSubjectEntity (uniqueSubjectRequestDTO);
        UniqueSubjectEntity uniqueSubjectAdded = uniqueSubjectRepository.save(uniqueSubjectToBeAdded);

        return uniqueSubjectMapper.uniqueSubjectEntityToUniqueSubjectResponseDTO(uniqueSubjectAdded);
    }

    @Override
    public UniqueSubjectResponseDTO findById(UUID uniqueSubjectId) {
        return uniqueSubjectRepository.findById(uniqueSubjectId)
                .map(uniqueSubjectMapper::uniqueSubjectEntityToUniqueSubjectResponseDTO)
                .orElseThrow(() -> new NotFoundException(String.format(
                        ExceptionCode.ERR001_UNIQUESUBJECT_NOT_FOUND.getMessage(),
                        uniqueSubjectId
                )));
    }

    @Override
    public UniqueSubjectResponseDTO update(UniqueSubjectRequestDTO uniqueSubjectRequestDTO, UUID uniqueSubjectId) {
        return uniqueSubjectRepository.findById(uniqueSubjectId)
                .map((uniqueSubjectEntity)-> {
                    uniqueSubjectEntity.setName(uniqueSubjectRequestDTO.getName());
                    uniqueSubjectEntity.setCAENSubject(uniqueSubjectRequestDTO.getCAENSubject());
                    uniqueSubjectEntity.setSubjectStudyYear(uniqueSubjectRequestDTO.getSubjectStudyYear());
                    uniqueSubjectEntity.setECTSCredits(uniqueSubjectEntity.getECTSCredits());
                    uniqueSubjectEntity.setFacultyCode(uniqueSubjectEntity.getFacultyCode());
                    uniqueSubjectEntity.setUniversityCode(uniqueSubjectEntity.getUniversityCode());

                    uniqueSubjectRepository.save(uniqueSubjectEntity);

                    return uniqueSubjectEntity;
                })
                .map(uniqueSubjectMapper::uniqueSubjectEntityToUniqueSubjectResponseDTO)
                .orElseThrow(() -> new NotFoundException(String.format(
                        ExceptionCode.ERR001_UNIQUESUBJECT_NOT_FOUND.getMessage(),
                        uniqueSubjectId
                )))
                ;
    }

    @Override
    public UniqueSubjectResponseDTO deleteById(UUID uniqueSubjectId) {
        List<UUID> ids = new ArrayList<>();
        ids.add(uniqueSubjectId);

        uniqueSubjectRepository.deleteAllByIdInBatch(ids);
        return null;
    }
}
