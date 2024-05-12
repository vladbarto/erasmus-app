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
import org.springframework.web.bind.annotation.*;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementRequestDTO;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementResponseDTO;
import ro.tucn.erasmusbackend.exception.ExceptionBody;
import ro.tucn.erasmusbackend.service.announcement.AnnouncementService;

import java.util.List;
import java.util.UUID;

/**
 * Manages interaction between client and server
 */
@RestController
@RequestMapping("/announcement/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @GetMapping("/{id}")
    @Operation(summary = "Gets one specific announcement", description = "the announcement must exist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Announcement found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = AnnouncementResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Announcement not found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))})
    })
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<AnnouncementResponseDTO> findById(@PathVariable("id") UUID announcementId) {
        return new ResponseEntity<>(
                announcementService.findById(announcementId),
                HttpStatus.OK
        );
    }
    
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
    @PostMapping("/one")
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

    @PutMapping("/{id}")
    @Operation(summary = "Update one announcement")
    @ApiResponse(responseCode = "301", description = "Announcement successfully updated",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = AnnouncementResponseDTO.class))})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AnnouncementResponseDTO> updateAnnouncement(
            @RequestBody AnnouncementRequestDTO announcementRequestDTO, @PathVariable("id") UUID announcementId
    ) {
        return new ResponseEntity<>(
                announcementService.update(announcementRequestDTO, announcementId),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete one announcement")
    @ApiResponse(responseCode = "301", description = "Announcement successfully deleted",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = AnnouncementResponseDTO.class))})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AnnouncementResponseDTO> deleteById(@PathVariable("id") UUID announcementId) {
        return new ResponseEntity<>(
                announcementService.deleteById(announcementId),
                HttpStatus.OK
        );
    }
}
