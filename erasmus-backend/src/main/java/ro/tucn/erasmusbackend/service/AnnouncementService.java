package ro.tucn.erasmusbackend.service;

import ro.tucn.erasmusbackend.dto.announcement.AnnouncementRequestDTO;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementResponseDTO;

import java.util.List;

public interface AnnouncementService {
    List<AnnouncementResponseDTO> findAll();
    AnnouncementResponseDTO save(AnnouncementRequestDTO announcementRequestDTO);
}
