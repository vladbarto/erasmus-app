package ro.tucn.erasmusbackend.dto.announcement;

import lombok.*;

import java.util.UUID;

/**
 * Server's response to the client
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AnnouncementResponseDTO {

    private UUID announcementId;
    private String title;
    private String description;
    private UUID representativeId;
    private String universityCode;
}
