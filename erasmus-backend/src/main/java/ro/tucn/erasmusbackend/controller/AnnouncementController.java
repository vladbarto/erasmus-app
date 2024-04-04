package ro.tucn.erasmusbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementRequestDTO;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementResponseDTO;
import ro.tucn.erasmusbackend.service.AnnouncementService;

import java.util.List;

@RestController
@RequestMapping("/announcement/v1")
@RequiredArgsConstructor
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @GetMapping("/all")
    public ResponseEntity<List<AnnouncementResponseDTO>> findAll() {
        return new ResponseEntity<>(
                announcementService.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/save-one")
    public ResponseEntity<AnnouncementResponseDTO> saveAnnouncement(
            @RequestBody AnnouncementRequestDTO announcementRequestDTO
    ) {
        return new ResponseEntity<>(
                announcementService.save(announcementRequestDTO),
                HttpStatus.CREATED
        );
    }
}
