package service;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import dto.ChefRequestDTO;
import dto.ChefResponseDTO;
import dto.CollectionResponseDTO;
import dto.PageRequestDTO;
import exception.ExceptionCode;
import exception.NotFoundException;
import mapper.ChefMapper;
import model.ChefEntity;
import repository.ChefRepository;

@Slf4j
@RequiredArgsConstructor
public class ChefServiceBean implements ChefService {

    private final ChefRepository chefRepository;
    private final ChefMapper chefMapper;
    private final String applicationName;

    @Override
    public ChefResponseDTO findById(UUID chefId) {
        //        Optional<ChefEntity> chefOptional = chefRepository.findById(chefId);
        //        if (chefOptional.isEmpty()) {
        //            throw new NotFoundException(
        //                    String.format(ExceptionCode.ERR001_CHEF_NOT_FOUND.getMessage(), chefId)
        //            );
        //        }
        //
        //        return chefMapper.chefEntityToChefResponseDTO(chefOptional.get());
        return chefRepository.findById(chefId)
                .map(chefMapper::chefEntityToChefResponseDTO)
                .orElseThrow(() -> new NotFoundException(String.format(
                        ExceptionCode.ERR001_CHEF_NOT_FOUND.getMessage(),
                        chefId
                )));
    }

    @Override
    public List<ChefResponseDTO> findAll() {
        log.info("Getting all chefs for application {}", applicationName);

        List<ChefEntity> chefEntityList = chefRepository.findAll();

        return chefMapper.chefEntityListToChefResponseDTOList(chefEntityList);
    }

    @Override
    public CollectionResponseDTO<ChefResponseDTO> findAllPaged(PageRequestDTO page) {
        Page<ChefEntity> chefEntityList = chefRepository.findAll(PageRequest.of(
                page.getPageNumber(),
                page.getPageSize()
        ));
        List<ChefResponseDTO> chefs = chefMapper.chefEntityListToChefResponseDTOList(chefEntityList.getContent());

        return new CollectionResponseDTO<>(chefs, chefEntityList.getTotalElements());
    }

    @Override
    public List<ChefResponseDTO> findAllSorted(String sortBy) {
        List<ChefEntity> chefEntityList = chefRepository.findAll(Sort.by(sortBy).descending());

        return chefMapper.chefEntityListToChefResponseDTOList(chefEntityList);
    }

    @Override
    public List<ChefResponseDTO> findAllByRatingGreaterThan(double rating) {
        List<ChefEntity> chefEntityList = chefRepository.findAllByRatingGreaterThan(rating);

        return chefMapper.chefEntityListToChefResponseDTOList(chefEntityList);
    }

    @Override
    @Transactional
    public ChefResponseDTO save(ChefRequestDTO chefRequestDTO) {
        ChefEntity chefToBeAdded = chefMapper.chefRequestDTOToChefEntity(chefRequestDTO);
        ChefEntity chefAdded = chefRepository.save(chefToBeAdded);

        return chefMapper.chefEntityToChefResponseDTO(chefAdded);
    }
}
