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
import ro.tucn.erasmusbackend.dto.bareSubject.BareSubjectRequestDTO;
import ro.tucn.erasmusbackend.dto.bareSubject.BareSubjectResponseDTO;
import ro.tucn.erasmusbackend.exception.ExceptionBody;
import ro.tucn.erasmusbackend.service.bareSubject.BareSubjectService;

import java.util.List;
import java.util.UUID;

/**
 * Manages interaction between client and server
 */
@RestController
@RequestMapping("/bare-subject/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class BareSubjectController {

    private final BareSubjectService bareSubjectService;
    
    /**
     * method that gets Bare Subjects by ID type UUID (its ID)
     */
    @GetMapping("/{id}")
    @Operation(summary = "Gets Bare Subjects by own Id", description = "Subject must exist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bare Subject found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BareSubjectResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Bare Subject not found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))})
    })
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<BareSubjectResponseDTO> findById(@PathVariable("id") UUID bareSubjectId) {
        return new ResponseEntity<>(
                bareSubjectService.findById(bareSubjectId),
                HttpStatus.OK
        );
    }
    
    /**
     * Method that returns to client all found bare subjects
     * @return list of all bare subjects and a http status
     */
    @GetMapping("/all")
    @Operation(summary = "Gets all bare subjects", description = "at least one bare subject must exist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bare subject found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BareSubjectResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Bare subject not found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))})
    })
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<BareSubjectResponseDTO>> findAll() {
        return new ResponseEntity<>(
                bareSubjectService.findAll(),
                HttpStatus.OK
        );
    }

    /**
     * Method that sends to the server a save request
     * @param bareSubjectRequestDTO - data of bare subject to be saved
     * @return the data to be saved and a http status
     */
    @PostMapping("/one")
    @Operation(summary = "Save one bare subject")
    @ApiResponse(responseCode = "201", description = "Bare subject successfully created",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BareSubjectResponseDTO.class))})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BareSubjectResponseDTO> saveBareSubject(
            @RequestBody BareSubjectRequestDTO bareSubjectRequestDTO
    ) {
        return new ResponseEntity<>(
                bareSubjectService.save(bareSubjectRequestDTO),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update one bareSubject")
    @ApiResponse(responseCode = "301", description = "BareSubject successfully updated",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BareSubjectResponseDTO.class))})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BareSubjectResponseDTO> updateBareSubject(
            @RequestBody BareSubjectRequestDTO bareSubjectRequestDTO, @PathVariable("id") UUID bareSubjectId
    ) {
        return new ResponseEntity<>(
                bareSubjectService.update(bareSubjectRequestDTO, bareSubjectId),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete one bareSubject")
    @ApiResponse(responseCode = "301", description = "BareSubject successfully deleted",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BareSubjectResponseDTO.class))})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BareSubjectResponseDTO> deleteById(@PathVariable("id") UUID bareSubjectId) {
        return new ResponseEntity<>(
                bareSubjectService.deleteById(bareSubjectId),
                HttpStatus.OK
        );
    }
}
