package ro.tucn.erasmusbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementRequestDTO;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementResponseDTO;
import ro.tucn.erasmusbackend.exception.ExceptionBody;
import ro.tucn.erasmusbackend.service.AnnouncementService;

import java.util.List;

/**
 * Manages interaction between client and server
 */
@RestController
@RequestMapping("/announcement/v1")
@RequiredArgsConstructor
public class AnnouncementController {

    private final AnnouncementService announcementService;

    /**
     * Method that returns to client all found announcements
     * @return list of all announcements and a http status
     */
    @GetMapping("/all")
    @Operation(summary = "Gets all announcements", description = "at least an announcement must exist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Announcement found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = AnnouncementResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Announcement not found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))})
    })
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<AnnouncementResponseDTO>> findAll() {
        return new ResponseEntity<>(
                announcementService.findAll(),
                HttpStatus.OK
        );
    }

    /**
     * Method that sends to the server a save request
     * @param announcementRequestDTO - data of announcement to be saved
     * @return the data to be saved and a http status
     */
    @PostMapping("/save-one")
    @Operation(summary = "Save one announcements")
    @ApiResponse(responseCode = "201", description = "Announcement successfully created",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = AnnouncementResponseDTO.class))})
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<AnnouncementResponseDTO> saveAnnouncement(
            @RequestBody AnnouncementRequestDTO announcementRequestDTO
    ) {
        return new ResponseEntity<>(
                announcementService.save(announcementRequestDTO),
                HttpStatus.CREATED
        );
    }
}
