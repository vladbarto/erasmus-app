package ro.tucn.erasmusbackend.dto.announcement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * Client's request to the server
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementRequestDTO {

    private String title;
    private String description;
    private UUID representativeId;
    private String universityCode;
}
