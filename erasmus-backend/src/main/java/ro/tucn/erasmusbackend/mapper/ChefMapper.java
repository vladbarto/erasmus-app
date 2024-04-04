package ro.tucn.erasmusbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.tucn.erasmusbackend.dto.ChefRequestDTO;
import ro.tucn.erasmusbackend.dto.ChefResponseDTO;
import ro.tucn.erasmusbackend.model.ChefEntity;

import java.util.List;

@Mapper
public interface ChefMapper {

        @Mapping(target = "numberOfStars", source = "rating")
        ChefResponseDTO chefEntityToChefResponseDTO(ChefEntity chefEntity);

        List<ChefResponseDTO> chefEntityListToChefResponseDTOList(List<ChefEntity> chefEntityList);

        ChefEntity chefRequestDTOToChefEntity(ChefRequestDTO chefRequestDTO);
}
