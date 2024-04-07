package ro.tucn.erasmusbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import ro.tucn.erasmusbackend.dto.representative.RepresentativeRequestDTO;
import ro.tucn.erasmusbackend.dto.representative.RepresentativeResponseDTO;
import ro.tucn.erasmusbackend.mapper.RepresentativeMapper;
import ro.tucn.erasmusbackend.model.RepresentativeEntity;
import ro.tucn.erasmusbackend.repository.RepresentativeRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class RepresentativeServiceBean implements RepresentativeService{

    private final RepresentativeRepository representativeRepository;
    private final RepresentativeMapper representativeMapper;
    private final String applicationName;

    @Override
    public List<RepresentativeResponseDTO> findAll() {
        log.info("Getting all chefs for application {}", applicationName);

        List<RepresentativeEntity> representativeEntityList = representativeRepository.findAll();

        return representativeMapper.representativeEntityListToRepresentativeResponseDTOList(representativeEntityList);
    }

    @Override
    @Transactional
    public RepresentativeResponseDTO save(RepresentativeRequestDTO representativeRequestDTO) {
        RepresentativeEntity representativeToBeAdded = representativeMapper.representativeRequestDTOToRepresentativeEntity(representativeRequestDTO);
        RepresentativeEntity representativeAdded = representativeRepository.save(representativeToBeAdded);

        return representativeMapper.representativeEntityToRepresentativeResponseDTO(representativeAdded);
    }
}
