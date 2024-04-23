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
import ro.tucn.erasmusbackend.dto.bareSubject.BareSubjectRequestDTO;
import ro.tucn.erasmusbackend.dto.bareSubject.BareSubjectResponseDTO;
import ro.tucn.erasmusbackend.exception.ExceptionBody;
import ro.tucn.erasmusbackend.service.bareSubject.BareSubjectService;

import java.util.List;
/**
 * Manages interaction between client and server
 */
@RestController
@RequestMapping("/bare-subject/v1")
@RequiredArgsConstructor
public class BareSubjectController {

    private final BareSubjectService bareSubjectService;

    /**
     * TO BE IMPLEMENTED: method that gets Bare Subjects by CAEN Code (its ID)
     */
    @GetMapping("/{id}")
    @Operation(summary = "Gets Bare Subjects by CAEN Code", description = "Subject must exist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bare Subject found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BareSubjectResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Bare Subject not found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))})
    })
    public void fct() {}

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
    @PostMapping("/save-one")
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
}
