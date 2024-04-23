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
import ro.tucn.erasmusbackend.dto.faculty.FacultyRequestDTO;
import ro.tucn.erasmusbackend.dto.faculty.FacultyResponseDTO;
import ro.tucn.erasmusbackend.exception.ExceptionBody;
import ro.tucn.erasmusbackend.service.faculty.FacultyService;

import java.util.List;
import java.util.UUID;

/**
 * Manages interaction between client and server
 */
@RestController
@RequestMapping("/faculty/v1")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;

    @GetMapping("/{id}")
    @Operation(summary = "Gets one specific faculty", description = "the faculty must exist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Faculty found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = FacultyResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Faculty not found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))})
    })
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<FacultyResponseDTO> findById(@PathVariable("id") UUID facultyId) {
        return new ResponseEntity<>(
                facultyService.findById(facultyId),
                HttpStatus.OK
        );
    }

    @GetMapping("/all")
    @Operation(summary = "Gets all faculties", description = "at least a faculty must exist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Faculty found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = FacultyResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Faculty not found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))})
    })
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<FacultyResponseDTO>> findAll() {
        return new ResponseEntity<>(
                facultyService.findAll(),
                HttpStatus.OK
        );
    }

    /**
     * Method that sends to the server a save request
     * @param facultyRequestDTO - data of faculty to be saved
     * @return the data to be saved and a http status
     */
    @PostMapping("/all")
    @Operation(summary = "Save one faculty")
    @ApiResponse(responseCode = "201", description = "Faculty successfully created",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = FacultyResponseDTO.class))})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FacultyResponseDTO> saveFaculty(
            @RequestBody FacultyRequestDTO facultyRequestDTO
    ) {
        return new ResponseEntity<>(
                facultyService.save(facultyRequestDTO),
                HttpStatus.CREATED
        );
    }


}