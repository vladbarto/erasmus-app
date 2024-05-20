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
import ro.tucn.erasmusbackend.dto.representative.RepresentativeRequestDTO;
import ro.tucn.erasmusbackend.dto.representative.RepresentativeResponseDTO;
import ro.tucn.erasmusbackend.exception.ExceptionBody;
import ro.tucn.erasmusbackend.service.representative.RepresentativeService;
import java.util.List;
import java.util.UUID;

/**
 * Manages interaction between client and server
 */
@RestController
@RequestMapping("/representative/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class RepresentativeController {

    private final RepresentativeService representativeService;

    /**
     * Method that returns to client all found representatives
     * @return list of all representatives and a http status
     */
    @GetMapping("/all")
    @Operation(summary = "Gets all representatives", description = "at least a representative must exist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Representative found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RepresentativeResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Representative not found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))})
    })
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
     * @return the data to be saved and a http status
     */
    @PostMapping("/one")
    @Operation(summary = "Save one representative")
    @ApiResponse(responseCode = "201", description = "Representative successfully created",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RepresentativeResponseDTO.class))})
    public ResponseEntity<RepresentativeResponseDTO> saveRepresentative(
            @RequestBody RepresentativeRequestDTO representativeRequestDTO
    ) {
        return new ResponseEntity<>(
                representativeService.save(representativeRequestDTO),
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
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RepresentativeResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Unique Subject not found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))})
    })
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<RepresentativeResponseDTO> findById(@PathVariable("id") UUID personId) {
        return new ResponseEntity<>(
                representativeService.findById(personId),
                HttpStatus.OK
        );
    }

//    @PutMapping("/{id}")
//    @Operation(summary = "Update one representative")
//    @ApiResponse(responseCode = "301", description = "Representative successfully updated",
//            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RepresentativeResponseDTO.class))})
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<RepresentativeResponseDTO> updateRepresentative(
//            @RequestBody RepresentativeRequestDTO representativeRequestDTO, @PathVariable("id") UUID representativeId
//    ) {
//        return new ResponseEntity<>(
//                representativeService.update(representativeRequestDTO, representativeId),
//                HttpStatus.OK
//        );
//    }
//
//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete one representative")
//    @ApiResponse(responseCode = "301", description = "Representative successfully deleted",
//            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RepresentativeResponseDTO.class))})
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<RepresentativeResponseDTO> deleteById(@PathVariable("id") UUID representativeId) {
//        return new ResponseEntity<>(
//                representativeService.deleteById(representativeId),
//                HttpStatus.OK
//        );
//    }
}
