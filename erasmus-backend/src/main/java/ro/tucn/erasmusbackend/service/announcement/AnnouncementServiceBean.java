package ro.tucn.erasmusbackend.service.announcement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementRequestDTO;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementResponseDTO;
import ro.tucn.erasmusbackend.exception.ExceptionCode;
import ro.tucn.erasmusbackend.exception.NotFoundException;
import ro.tucn.erasmusbackend.mapper.AnnouncementMapper;
import ro.tucn.erasmusbackend.model.AnnouncementEntity;
import ro.tucn.erasmusbackend.repository.AnnouncementRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class AnnouncementServiceBean implements AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final AnnouncementMapper announcementMapper;
    private final String applicationName;

    @Override
    public List<AnnouncementResponseDTO> findAll() {
        log.info("Getting all announcements for application {}", applicationName);
        List<AnnouncementEntity> announcementEntityList = announcementRepository.findAll();

        return announcementMapper.announcementEntityListToAnnouncementResponseDTOList(announcementEntityList);
    }

    @Override
    public AnnouncementResponseDTO findById(UUID announcementId) {
        return announcementRepository.findById(announcementId)
                .map(announcementMapper::announcementEntityToAnnouncementResponseDTO)
                .orElseThrow(() -> new NotFoundException(String.format(
                        ExceptionCode.ERR001_ANNOUNCEMENT_NOT_FOUND.getMessage(),
                        announcementId
                )));
    }

    @Override
    @Transactional
    public AnnouncementResponseDTO save(AnnouncementRequestDTO announcementRequestDTO) {
        log.info("Posting an announcement for application {}", applicationName);
        AnnouncementEntity announcementToBeAdded = announcementMapper.announcementRequestDTOToAnnouncementEntity(announcementRequestDTO);
        AnnouncementEntity announcementAdded = announcementRepository.save(announcementToBeAdded);

        return announcementMapper.announcementEntityToAnnouncementResponseDTO(announcementAdded);
    }

    @Override
    public AnnouncementResponseDTO update(AnnouncementRequestDTO announcementRequestDTO, UUID announcementId) {
        return announcementRepository.findById(announcementId)
                .map((announcementEntity)-> {
                    announcementEntity.setTitle(announcementRequestDTO.getTitle());
                    announcementEntity.setRepresentativeId(announcementRequestDTO.getRepresentativeId());
                    announcementEntity.setDescription(announcementRequestDTO.getDescription());
                    announcementEntity.setUniversityCode(announcementRequestDTO.getUniversityCode());

                    announcementRepository.save(announcementEntity);

                    return announcementEntity;
                })
                .map(announcementMapper::announcementEntityToAnnouncementResponseDTO)
                .orElseThrow(() -> new NotFoundException(String.format(
                        ExceptionCode.ERR001_ANNOUNCEMENT_NOT_FOUND.getMessage(),
                        announcementId
                )))
                ;
    }

    @Override
    public AnnouncementResponseDTO deleteById(UUID announcementId) {
        List<UUID> ids = new ArrayList<>();
        ids.add(announcementId);

        announcementRepository.deleteAllByIdInBatch(ids);
        return null;
    }

}
