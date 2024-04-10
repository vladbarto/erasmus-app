package ro.tucn.erasmusbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.tucn.erasmusbackend.dto.representative.RepresentativeRequestDTO;
import ro.tucn.erasmusbackend.dto.representative.RepresentativeResponseDTO;
import ro.tucn.erasmusbackend.service.RepresentativeService;
import java.util.List;

/**
 * Manages interaction between client and server
 */
@RestController
@RequestMapping("/representative/v1")
@RequiredArgsConstructor
public class RepresentativeController {

    private final RepresentativeService representativeService;

    /**
     * Method that returns to client all found representatives
     * @return list of all representatives and an http status
     */
    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<RepresentativeResponseDTO>> findAll() {
        return new ResponseEntity<>(
                representativeService.findAll(),
                HttpStatus.OK
        );
    }

    /**
     * Method that sends to the server a save request
     * @param representativeRequestDTO - data of representative to be saved
     * @return the data to be saved and an http status
     */
    @PostMapping("/save-one")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RepresentativeResponseDTO> saveRepresentative(
            @RequestBody RepresentativeRequestDTO representativeRequestDTO
    ) {
        return new ResponseEntity<>(
                representativeService.save(representativeRequestDTO),
                HttpStatus.CREATED
        );
    }
}
