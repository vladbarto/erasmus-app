package ro.tucn.erasmusbackend.service.announcement;

import ro.tucn.erasmusbackend.dto.announcement.AnnouncementRequestDTO;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementResponseDTO;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementRequestDTO;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementResponseDTO;

import java.util.List;
import java.util.UUID;

/**
 * Service class that defines Announcement CRUD operations
 * This includes:
 * - Finding all announcements
 * - Saving an announcement
 */
public interface AnnouncementService {
    /**
     * Method that returns all announcements
     * @return list of all announcements
     */

    List<AnnouncementResponseDTO> findAll();

    /**
     * Method that saves an announcement
     * @param announcementRequestDTO - object that stores the attributes by which an announcement should be saved
     * @return object of type ResponseDTO containing all attributes of an Announcement saved in DB
     */
    AnnouncementResponseDTO save(AnnouncementRequestDTO announcementRequestDTO);

    /**
     * Method that returns details of a announcement
     * @param announcementId desired announcement id
     * @return details of desired announcement
     */
    AnnouncementResponseDTO findById(UUID announcementId);

    AnnouncementResponseDTO update(AnnouncementRequestDTO announcementRequestDTO, UUID announcementId);

    AnnouncementResponseDTO deleteById(UUID announcementId);
}
