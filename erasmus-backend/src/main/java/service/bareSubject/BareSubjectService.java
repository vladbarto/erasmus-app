package service.bareSubject;

import dto.bareSubject.BareSubjectRequestDTO;
import dto.bareSubject.BareSubjectResponseDTO;

public interface BareSubjectService {
    BareSubjectResponseDTO save(BareSubjectRequestDTO bareSubjectRequestDTO);
}
