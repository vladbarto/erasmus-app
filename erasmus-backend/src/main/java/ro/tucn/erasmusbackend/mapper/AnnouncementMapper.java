package ro.tucn.erasmusbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementRequestDTO;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementResponseDTO;
import ro.tucn.erasmusbackend.model.AnnouncementEntity;


import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;

@Mapper
public interface AnnouncementMapper {
    //@Mapping(target = "numberOfStars", source = "rating")
    AnnouncementResponseDTO announcementEntityToAnnouncementResponseDTO(AnnouncementEntity announcementEntity);

    List<AnnouncementResponseDTO> announcementEntityListToAnnouncementResponseDTOList(List<AnnouncementEntity> announcementEntityList);

    AnnouncementEntity announcementRequestDTOToAnnouncementEntity(AnnouncementRequestDTO announcementRequestDTO);
    // Mapping method to convert int to UUID
    public static UUID map(int value) {
        // Convert the integer value to a UUID
        return new UUID(value, 0);
    }
    public static int map(UUID value) {
        // Convert the UUID to a long and then to an int
        ByteBuffer buffer = ByteBuffer.wrap(new byte[16]);
        buffer.putLong(value.getMostSignificantBits());
        buffer.putLong(value.getLeastSignificantBits());
        return Math.abs(buffer.getInt()); // Using absolute value to handle negative integers
    }
}
