package ro.tucn.erasmusbackend.service;

import ro.tucn.erasmusbackend.dto.representative.RepresentativeRequestDTO;
import ro.tucn.erasmusbackend.dto.representative.RepresentativeResponseDTO;

import java.util.List;

public interface RepresentativeService {
    List<RepresentativeResponseDTO> findAll();

    RepresentativeResponseDTO save(RepresentativeRequestDTO representativeRequestDTO);
}
