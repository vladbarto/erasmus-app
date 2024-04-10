package ro.tucn.erasmusbackend.service;

import ro.tucn.erasmusbackend.dto.announcement.AnnouncementRequestDTO;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementResponseDTO;

import java.util.List;

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
}
