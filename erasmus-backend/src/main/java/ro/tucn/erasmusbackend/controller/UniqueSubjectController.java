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
import ro.tucn.erasmusbackend.dto.uniqueSubject.UniqueSubjectRequestDTO;
import ro.tucn.erasmusbackend.dto.uniqueSubject.UniqueSubjectResponseDTO;
import ro.tucn.erasmusbackend.exception.ExceptionBody;
import ro.tucn.erasmusbackend.service.uniqueSubject.UniqueSubjectService;

import java.util.List;
import java.util.UUID;

/**
 * Manages interaction between client and server
 */
@RestController
@RequestMapping("/unique-subject/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class UniqueSubjectController {
    private final UniqueSubjectService uniqueSubjectService;

    /**
     * Method that returns to client all found unique subjects
     * @return list of all unique subjects and an http status
     */
    @GetMapping("/all")
    @Operation(summary = "Gets all unique subjects", description = "at least one unique subject must exist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Unique Subject found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UniqueSubjectResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Unique Subject not found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))})
    })
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<UniqueSubjectResponseDTO>> findAll() {
        return new ResponseEntity<>(
                uniqueSubjectService.findAll(),
                HttpStatus.OK
        );
    }

    /**
     * Method that sends to the server a save request
     * @param uniqueSubjectRequestDTO - data of unique subject to be saved
     * @return the data to be saved and a http status
     */
    @PostMapping("/one")
    @Operation(summary = "Save one unique subject")
    @ApiResponse(responseCode = "201", description = "Unique subject successfully created",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UniqueSubjectResponseDTO.class))})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UniqueSubjectResponseDTO> saveUniqueSubject(
            @RequestBody UniqueSubjectRequestDTO uniqueSubjectRequestDTO
    ) {
        return new ResponseEntity<>(
                uniqueSubjectService.save(uniqueSubjectRequestDTO),
                HttpStatus.CREATED
        );
    }

    /**
     * method that gets Unique Subjects by ID type UUID (its ID)
     */
    @GetMapping("/{id}")
    @Operation(summary = "Gets Unique Subjects by CAEN Code", description = "Subject must exist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Unique Subject found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UniqueSubjectResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Unique Subject not found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))})
    })
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<UniqueSubjectResponseDTO> findById(@PathVariable("id") UUID uniqueSubjectId) {
        return new ResponseEntity<>(
                uniqueSubjectService.findById(uniqueSubjectId),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update one uniqueSubject")
    @ApiResponse(responseCode = "301", description = "UniqueSubject successfully updated",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UniqueSubjectResponseDTO.class))})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UniqueSubjectResponseDTO> updateUniqueSubject(
            @RequestBody UniqueSubjectRequestDTO uniqueSubjectRequestDTO, @PathVariable("id") UUID uniqueSubjectId
    ) {
        return new ResponseEntity<>(
                uniqueSubjectService.update(uniqueSubjectRequestDTO, uniqueSubjectId),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete one uniqueSubject")
    @ApiResponse(responseCode = "301", description = "UniqueSubject successfully deleted",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UniqueSubjectResponseDTO.class))})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UniqueSubjectResponseDTO> deleteById(@PathVariable("id") UUID uniqueSubjectId) {
        return new ResponseEntity<>(
                uniqueSubjectService.deleteById(uniqueSubjectId),
                HttpStatus.OK
        );
    }
}
