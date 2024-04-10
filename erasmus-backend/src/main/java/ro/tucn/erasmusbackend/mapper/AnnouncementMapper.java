package ro.tucn.erasmusbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementRequestDTO;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementResponseDTO;
import ro.tucn.erasmusbackend.model.AnnouncementEntity;


import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;

/**
 * Mapper that handles conversion of announcements between database (as entity object) and Request DTO and Response DTO respectively.
 */
@Mapper
public interface AnnouncementMapper {

    /**
     * Method that receives data (one object) from DB and prepares it as a response
     * @param announcementEntity - response from DB
     * @return data in form of a response dto object
     */
    AnnouncementResponseDTO announcementEntityToAnnouncementResponseDTO(AnnouncementEntity announcementEntity);

    /**
     * Method that receives data (more objects) from DB and prepares it as a response
     * @param announcementEntityList - a list of (all) objects from DB
     * @return list of (all) data in form of a response dto
     */
    List<AnnouncementResponseDTO> announcementEntityListToAnnouncementResponseDTOList(List<AnnouncementEntity> announcementEntityList);

    /**
     * Method that gets data from user, and it is asked to update the DB
     * @param announcementRequestDTO - an object from user (client) to be stored in DB
     * @return the object suitable for DB update
     */
    AnnouncementEntity announcementRequestDTOToAnnouncementEntity(AnnouncementRequestDTO announcementRequestDTO);

    /**
     * Mapping method to convert int to UUID
     * @param value - given int
     * @return a new UUID based on `value`
     */
    public static UUID map(int value) {
        /**
         * Convert the integer value to a UUID
         */
        return new UUID(value, 0);
    }

    /**
     * Mapping method to convert UUID to int
     * @param value - given UUID
     * @return a new int based on the given UUID
     */
    public static int map(UUID value) {

        /**
         * Convert the UUID to a long and then to an int
         */
        ByteBuffer buffer = ByteBuffer.wrap(new byte[16]);
        buffer.putLong(value.getMostSignificantBits());
        buffer.putLong(value.getLeastSignificantBits());

        /**
         * Using absolute value to handle negative integers
         */
        return Math.abs(buffer.getInt());
    }
}
