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
import ro.tucn.erasmusbackend.dto.person.PersonRequestDTO;
import ro.tucn.erasmusbackend.dto.person.PersonResponseDTO;
import ro.tucn.erasmusbackend.exception.ExceptionBody;
import ro.tucn.erasmusbackend.service.person.PersonService;

import java.util.List;
import java.util.UUID;

/**
 * Manages interaction between client and server
 */
@RestController
@RequestMapping("/person/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class PersonController {
    private final PersonService personService;

    /**
     * Method that returns to client all found persons
     * @return list of all persons and a http status
     */
    @GetMapping("/all")
    @Operation(summary = "Gets all persons", description = "at least an person must exist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Person found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PersonResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Person not found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))})
    })
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<PersonResponseDTO>> findAll() {
        return new ResponseEntity<>(
                personService.findAll(),
                HttpStatus.OK
        );
    }

    /**
     * Method that sends to the server a save request
     * @param personRequestDTO - data of person to be saved
     * @return the data to be saved and a http status
     */
    @PostMapping("/one")
    @Operation(summary = "Save one Person")
    @ApiResponse(responseCode = "201", description = "Person successfully created",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PersonResponseDTO.class))})
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<PersonResponseDTO> savePerson(
            @RequestBody PersonRequestDTO personRequestDTO
    ) {
        return new ResponseEntity<>(
                personService.save(personRequestDTO),
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
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PersonResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Unique Subject not found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))})
    })
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<PersonResponseDTO> findById(@PathVariable("id") UUID personId) {
        return new ResponseEntity<>(
                personService.findById(personId),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update one person")
    @ApiResponse(responseCode = "301", description = "Person successfully updated",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PersonResponseDTO.class))})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PersonResponseDTO> updatePerson(
            @RequestBody PersonRequestDTO personRequestDTO, @PathVariable("id") UUID personId
    ) {
        return new ResponseEntity<>(
                personService.update(personRequestDTO, personId),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete one person")
    @ApiResponse(responseCode = "301", description = "Person successfully deleted",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PersonResponseDTO.class))})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PersonResponseDTO> deleteById(@PathVariable("id") UUID personId) {
        return new ResponseEntity<>(
                personService.deleteById(personId),
                HttpStatus.OK
        );
    }
//    @DeleteMapping("/{name}")
//    @Operation(summary = "Delete one Person")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "Person successfully deleted",
//                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PersonResponseDTO.class))}),
//            @ApiResponse(responseCode = "409", description = "Nonexistent person",
//                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))}),
//            @ApiResponse(responseCode = "500", description = "Internal server error",
//                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))})
//    })
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<PersonResponseDTO> deletePerson(@PathVariable("name") String name) {
//        Optional<PersonEntity> existingPerson = this.personService.findByName(name);
//        if(existingPerson.isPresent()){
//            this.personService.delete(existingPerson.get());
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
}
