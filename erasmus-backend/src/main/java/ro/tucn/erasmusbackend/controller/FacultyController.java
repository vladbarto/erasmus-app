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
import ro.tucn.erasmusbackend.dto.faculty.FacultyRequestDTO;
import ro.tucn.erasmusbackend.dto.faculty.FacultyResponseDTO;
import ro.tucn.erasmusbackend.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty/v1")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;

    @GetMapping("/all")
    public ResponseEntity<List<FacultyResponseDTO>> findAll() {
        return new ResponseEntity<>(
                facultyService.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/save-one")
    public ResponseEntity<FacultyResponseDTO> saveFaculty(
            @RequestBody FacultyRequestDTO facultyRequestDTO
    ) {
        return new ResponseEntity<>(
                facultyService.save(facultyRequestDTO),
                HttpStatus.CREATED
        );
    }
}