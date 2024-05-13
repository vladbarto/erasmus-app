package ro.tucn.erasmusbackend.service.bareSubject;

import ro.tucn.erasmusbackend.dto.bareSubject.BareSubjectRequestDTO;
import ro.tucn.erasmusbackend.dto.bareSubject.BareSubjectResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ro.tucn.erasmusbackend.dto.bareSubject.BareSubjectRequestDTO;
import ro.tucn.erasmusbackend.dto.bareSubject.BareSubjectResponseDTO;
import ro.tucn.erasmusbackend.exception.ExceptionCode;
import ro.tucn.erasmusbackend.exception.NotFoundException;
import ro.tucn.erasmusbackend.mapper.BareSubjectMapper;
import ro.tucn.erasmusbackend.model.BareSubjectEntity;
import org.springframework.transaction.annotation.Transactional;
import ro.tucn.erasmusbackend.repository.BareSubjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @Override
    public BareSubjectResponseDTO findById(UUID bareSubjectId) {
        return bareSubjectRepository.findById(bareSubjectId)
                .map(bareSubjectMapper::bareSubjectEntityToBareSubjectResponseDTO)
                .orElseThrow(() -> new NotFoundException(String.format(
                        ExceptionCode.ERR001_BARESUBJECT_NOT_FOUND.getMessage(),
                        bareSubjectId
                )));
    }

    @Override
    public BareSubjectResponseDTO update(BareSubjectRequestDTO bareSubjectRequestDTO, UUID bareSubjectId) {
        return bareSubjectRepository.findById(bareSubjectId)
                .map((bareSubjectEntity)-> {
                    bareSubjectEntity.setCompositeKey(bareSubjectRequestDTO.getCompositeKey());
                    bareSubjectEntity.setCAENSubject(bareSubjectRequestDTO.getCAENSubject());
                    bareSubjectEntity.setDescription(bareSubjectRequestDTO.getDescription());

                    bareSubjectRepository.save(bareSubjectEntity);

                    return bareSubjectEntity;
                })
                .map(bareSubjectMapper::bareSubjectEntityToBareSubjectResponseDTO)
                .orElseThrow(() -> new NotFoundException(String.format(
                        ExceptionCode.ERR001_BARESUBJECT_NOT_FOUND.getMessage(),
                        bareSubjectId
                )))
                ;
    }

    @Override
    public BareSubjectResponseDTO deleteById(UUID bareSubjectId) {
        List<UUID> ids = new ArrayList<>();
        ids.add(bareSubjectId);

        bareSubjectRepository.deleteAllByIdInBatch(ids);
        return null;
    }
}
