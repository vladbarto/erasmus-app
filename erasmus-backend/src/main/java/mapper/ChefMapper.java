package mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import dto.ChefRequestDTO;
import dto.ChefResponseDTO;
import model.ChefEntity;

import java.util.List;

@Mapper
public interface ChefMapper {

        @Mapping(target = "numberOfStars", source = "rating")
        ChefResponseDTO chefEntityToChefResponseDTO(ChefEntity chefEntity);

        List<ChefResponseDTO> chefEntityListToChefResponseDTOList(List<ChefEntity> chefEntityList);

        ChefEntity chefRequestDTOToChefEntity(ChefRequestDTO chefRequestDTO);
}
