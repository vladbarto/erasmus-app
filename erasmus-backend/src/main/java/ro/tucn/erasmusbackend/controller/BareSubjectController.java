package ro.tucn.erasmusbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.tucn.erasmusbackend.dto.ChefResponseDTO;
import ro.tucn.erasmusbackend.dto.bareSubject.BareSubjectRequestDTO;
import ro.tucn.erasmusbackend.dto.bareSubject.BareSubjectResponseDTO;
import ro.tucn.erasmusbackend.exception.ExceptionBody;
import ro.tucn.erasmusbackend.service.BareSubjectService;

import java.util.List;

@RestController
@RequestMapping("/bare-subject/v1")
@RequiredArgsConstructor
public class BareSubjectController {

    private final BareSubjectService bareSubjectService;

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
    public void fct() {
        ;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BareSubjectResponseDTO>> findAll() {
        return new ResponseEntity<>(
                bareSubjectService.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/post")
    public ResponseEntity<BareSubjectResponseDTO> saveBareSubject(
            @RequestBody BareSubjectRequestDTO bareSubjectRequestDTO
    ) {
        return new ResponseEntity<>(
                bareSubjectService.save(bareSubjectRequestDTO),
                HttpStatus.CREATED
        );
    }
}
