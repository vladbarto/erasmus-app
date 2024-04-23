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
import ro.tucn.erasmusbackend.dto.university.UniversityRequestDTO;
import ro.tucn.erasmusbackend.dto.university.UniversityResponseDTO;
import ro.tucn.erasmusbackend.exception.ExceptionBody;
import ro.tucn.erasmusbackend.service.university.UniversityService;

import java.util.List;
/**
 * Manages interaction between client and server
 */
@RestController
@RequestMapping("/university/v1")
@RequiredArgsConstructor
public class UniversityController {

    private final UniversityService universityService;

    /**
     * Method that returns to client all found universities
     * @return list of all universities and a http status
     */
    @GetMapping("/all")
    @Operation(summary = "Gets all universities", description = "at least one university must exist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "University found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UniversityResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "University not found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))})
    })
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<UniversityResponseDTO>> findAll() {
        return new ResponseEntity<>(
                universityService.findAll(),
                HttpStatus.OK
        );
    }

    /**
     * Method that sends to the server a save request
     * @param universityRequestDTO - data of university to be saved
     * @return the data to be saved and a http status
     */
    @PostMapping("/save-one")
    @Operation(summary = "Save one university")
    @ApiResponse(responseCode = "201", description = "University successfully created",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UniversityResponseDTO.class))})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UniversityResponseDTO> saveUniversity(
            @RequestBody UniversityRequestDTO universityRequestDTO
    ) {
        return new ResponseEntity<>(
                universityService.save(universityRequestDTO),
                HttpStatus.CREATED
        );
    }
}
