package ro.tucn.erasmusbackend.service.representative;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import ro.tucn.erasmusbackend.dto.representative.RepresentativeResponseDTO;
import ro.tucn.erasmusbackend.dto.representative.RepresentativeRequestDTO;
import ro.tucn.erasmusbackend.exception.ExceptionCode;
import ro.tucn.erasmusbackend.exception.NotFoundException;
import ro.tucn.erasmusbackend.mapper.RepresentativeMapper;
import ro.tucn.erasmusbackend.model.RepresentativeEntity;
import ro.tucn.erasmusbackend.repository.RepresentativeRepository;

import java.util.List;
import java.util.UUID;

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

        return representativeMapper.entityListToResponseDTOList(representativeEntityList);
    }

    @Override
    @Transactional
    public RepresentativeResponseDTO save(RepresentativeRequestDTO representativeRequestDTO) {
        log.info("Posting an announcement for application {}", applicationName);
        RepresentativeEntity representativeToBeAdded = representativeMapper.requestDTOToEntity(representativeRequestDTO);
        RepresentativeEntity representativeAdded = representativeRepository.save(representativeToBeAdded);

        return representativeMapper.entityToResponseDTO(representativeAdded);
    }

    @Override
    public RepresentativeResponseDTO findById(UUID personId) {
        return representativeRepository.findById(personId)
                .map(representativeMapper::entityToResponseDTO)
                .orElseThrow(() -> new NotFoundException(String.format(
                        ExceptionCode.ERR001_REPRESENTATIVE_NOT_FOUND.getMessage(),
                        personId
                )));
    }
}
