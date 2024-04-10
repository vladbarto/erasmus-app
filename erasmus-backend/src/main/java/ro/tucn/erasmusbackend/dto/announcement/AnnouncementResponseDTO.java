package ro.tucn.erasmusbackend.dto.announcement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * Server's response to the client
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementResponseDTO {

    private UUID announcementId;
    private String title;
    private String description;
    private UUID representativeId;
    private String universityCode;
}
