package ro.tucn.erasmusbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementRequestDTO;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementResponseDTO;
import ro.tucn.erasmusbackend.mapper.AnnouncementMapper;
import ro.tucn.erasmusbackend.model.AnnouncementEntity;
import ro.tucn.erasmusbackend.repository.AnnouncementRepository;

import java.util.List;

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
    @Transactional
    public AnnouncementResponseDTO save(AnnouncementRequestDTO announcementRequestDTO) {
        AnnouncementEntity announcementToBeAdded = announcementMapper.announcementRequestDTOToAnnouncementEntity(announcementRequestDTO);
        AnnouncementEntity announcementAdded = announcementRepository.save(announcementToBeAdded);

        return announcementMapper.announcementEntityToAnnouncementResponseDTO(announcementAdded);
    }
}
