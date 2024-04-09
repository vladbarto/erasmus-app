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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.tucn.erasmusbackend.dto.uniqueSubject.UniqueSubjectRequestDTO;
import ro.tucn.erasmusbackend.dto.uniqueSubject.UniqueSubjectResponseDTO;
import ro.tucn.erasmusbackend.exception.ExceptionBody;
import ro.tucn.erasmusbackend.service.UniqueSubjectService;

import java.util.List;

@RestController
@RequestMapping("/unique-subject/v1")
@RequiredArgsConstructor
public class UniqueSubjectController {
    private final UniqueSubjectService uniqueSubjectService;

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
    public void fct() {
        ;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<UniqueSubjectResponseDTO>> findAll() {
        return new ResponseEntity<>(
                uniqueSubjectService.findAll(),
                HttpStatus.OK
        );
    }


    @PostMapping("/save-one")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UniqueSubjectResponseDTO> saveUniqueSubject(
            @RequestBody UniqueSubjectRequestDTO uniqueSubjectRequestDTO
    ) {
        return new ResponseEntity<>(
                uniqueSubjectService.save(uniqueSubjectRequestDTO),
                HttpStatus.CREATED
        );
    }
}
