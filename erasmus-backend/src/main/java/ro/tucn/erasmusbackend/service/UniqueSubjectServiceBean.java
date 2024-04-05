package ro.tucn.erasmusbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import ro.tucn.erasmusbackend.dto.uniqueSubject.UniqueSubjectRequestDTO;
import ro.tucn.erasmusbackend.dto.uniqueSubject.UniqueSubjectResponseDTO;
import ro.tucn.erasmusbackend.mapper.UniqueSubjectMapper;
import ro.tucn.erasmusbackend.model.UniqueSubjectEntity;
import ro.tucn.erasmusbackend.repository.UniqueSubjectRepository;

import java.util.List;

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
}
