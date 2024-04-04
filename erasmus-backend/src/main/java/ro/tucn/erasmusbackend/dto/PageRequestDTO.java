
package ro.tucn.erasmusbackend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.tucn.erasmusbackend.validator.OddPageSize;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {

    @NotNull(message = "Page number is requested")
    private Integer pageNumber;
    @OddPageSize
    private Integer pageSize = 20;
}
