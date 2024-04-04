package ro.tucn.erasmusbackend.service;

import org.springframework.stereotype.Service;
import ro.tucn.erasmusbackend.dto.ChefResponseDTO;
import ro.tucn.erasmusbackend.dto.bareSubject.BareSubjectRequestDTO;
import ro.tucn.erasmusbackend.dto.bareSubject.BareSubjectResponseDTO;

import java.util.List;

@Service
public interface BareSubjectService {

    List<BareSubjectResponseDTO> findAll();
    BareSubjectResponseDTO save(BareSubjectRequestDTO bareSubjectRequestDTO);
}
