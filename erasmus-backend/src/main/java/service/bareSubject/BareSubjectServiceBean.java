package service.bareSubject;

import dto.bareSubject.BareSubjectRequestDTO;
import dto.bareSubject.BareSubjectResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mapper.BareSubjectMapper;
import model.BareSubjectEntity;
import org.springframework.transaction.annotation.Transactional;
import repository.BareSubjectRepository;

@Slf4j
@RequiredArgsConstructor
public class BareSubjectServiceBean implements BareSubjectService{
    private final BareSubjectRepository bareSubjectRepository;
    private final BareSubjectMapper bareSubjectMapper;
    private final String applicationName;
    @Override
    @Transactional
    public BareSubjectResponseDTO save(BareSubjectRequestDTO bareSubjectRequestDTO) {
        BareSubjectEntity bareSubjectToBeAdded = bareSubjectMapper.bareSubjectRequestDTOToBareSubjectEntity (bareSubjectRequestDTO);
        BareSubjectEntity bareSubjectAdded = bareSubjectRepository.save(bareSubjectToBeAdded);

        return bareSubjectMapper.bareSubjectEntityToBareSubjectResponseDTO(bareSubjectAdded);
    }
}
