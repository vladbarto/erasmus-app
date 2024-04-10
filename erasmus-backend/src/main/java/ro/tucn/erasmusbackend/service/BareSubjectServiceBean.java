package ro.tucn.erasmusbackend.service;

import ro.tucn.erasmusbackend.dto.bareSubject.BareSubjectRequestDTO;
import ro.tucn.erasmusbackend.dto.bareSubject.BareSubjectResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ro.tucn.erasmusbackend.mapper.BareSubjectMapper;
import ro.tucn.erasmusbackend.model.BareSubjectEntity;
import org.springframework.transaction.annotation.Transactional;
import ro.tucn.erasmusbackend.repository.BareSubjectRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class BareSubjectServiceBean implements BareSubjectService {
    private final BareSubjectRepository bareSubjectRepository;
    private final BareSubjectMapper bareSubjectMapper;
    private final String applicationName;

    @Override
    public List<BareSubjectResponseDTO> findAll() {
        log.info("Getting all bare-subjects for application {}", applicationName);

        List<BareSubjectEntity> bareSubjectEntityList = bareSubjectRepository.findAll();

        return bareSubjectMapper.bareSubjectEntityListToBareSubjectResponseDTOList(bareSubjectEntityList);
    }

    @Override
    @Transactional
    public BareSubjectResponseDTO save(BareSubjectRequestDTO bareSubjectRequestDTO) {
        log.info("Posting a bare subject for application {}", applicationName);
        BareSubjectEntity bareSubjectToBeAdded = bareSubjectMapper.bareSubjectRequestDTOToBareSubjectEntity (bareSubjectRequestDTO);
        BareSubjectEntity bareSubjectAdded = bareSubjectRepository.save(bareSubjectToBeAdded);

        return bareSubjectMapper.bareSubjectEntityToBareSubjectResponseDTO(bareSubjectAdded);
    }
}
