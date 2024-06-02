package ro.tucn.erasmusbackend.dto.announcement;

import lombok.*;

import java.util.UUID;

/**
 * Client's request to the server
 */
@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementRequestDTO {

    private String title;
    private String description;
    private UUID representativeId;
    private String universityCode;
}
