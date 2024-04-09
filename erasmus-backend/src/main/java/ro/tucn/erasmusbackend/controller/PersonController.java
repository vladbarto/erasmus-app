package ro.tucn.erasmusbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.tucn.erasmusbackend.dto.person.PersonRequestDTO;
import ro.tucn.erasmusbackend.dto.person.PersonResponseDTO;
import ro.tucn.erasmusbackend.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person/v1")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<PersonResponseDTO>> findAll() {
        return new ResponseEntity<>(
                personService.findAll(),
                HttpStatus.OK
        );
    }

    @PostMapping("/save-one")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<PersonResponseDTO> savePerson(
            @RequestBody PersonRequestDTO personRequestDTO
    ) {
        return new ResponseEntity<>(
                personService.save(personRequestDTO),
                HttpStatus.CREATED
        );
    }
}
