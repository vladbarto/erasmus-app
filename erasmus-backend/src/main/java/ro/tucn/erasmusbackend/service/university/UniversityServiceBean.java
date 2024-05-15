package ro.tucn.erasmusbackend.service.university;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import ro.tucn.erasmusbackend.dto.university.UniversityRequestDTO;
import ro.tucn.erasmusbackend.dto.university.UniversityResponseDTO;
import ro.tucn.erasmusbackend.exception.ExceptionCode;
import ro.tucn.erasmusbackend.exception.NotFoundException;
import ro.tucn.erasmusbackend.mapper.UniversityMapper;
import ro.tucn.erasmusbackend.model.UniversityEntity;
import ro.tucn.erasmusbackend.repository.UniversityRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor

public class UniversityServiceBean implements UniversityService{
    private final UniversityRepository universityRepository;
    private final UniversityMapper universityMapper;
    private final String applicationName;

    @Override
    public List<UniversityResponseDTO> findAll() {
        log.info("Getting all chefs for application {}", applicationName);

        List<UniversityEntity> universityEntityList = universityRepository.findAll();

        return universityMapper.universityEntityListToUniversityResponseDTOList(universityEntityList);
    }

    @Override
    @Transactional
    public UniversityResponseDTO save(UniversityRequestDTO universityRequestDTO) {
        UniversityEntity universityToBeAdded = universityMapper.universityRequestDTOToUniversityEntity(universityRequestDTO);
        UniversityEntity universityAdded = universityRepository.save(universityToBeAdded);

        return universityMapper.universityEntityToUniversityResponseDTO(universityAdded);
    }

//    @Override
//    public UniversityResponseDTO findByCode(String universityCode) {
//        return universityRepository.findByCode(universityCode)
//                .map(universityMapper::universityEntityToUniversityResponseDTO)
//                .orElseThrow(() -> new NotFoundException(String.format(
//                        ExceptionCode.ERR002_UNIVERSITYCODE_NOT_FOUND.getMessage(),
//                        universityCode
//                )));
//    }
//
//    @Override
//    public UniversityResponseDTO update(UniversityRequestDTO universityRequestDTO, String universityCode) {
//        return universityRepository.findById(universityCode)
//                .map((universityEntity)-> {
//                    universityEntity.setCity(universityRequestDTO.getCity());
//                    universityEntity.setName(universityRequestDTO.getName());
//                    universityEntity.setCountry(universityRequestDTO.getCountry());
//
//                    universityRepository.save(universityEntity);
//
//                    return universityEntity;
//                })
//                .map(universityMapper::universityEntityToUniversityResponseDTO)
//                .orElseThrow(() -> new NotFoundException(String.format(
//                        ExceptionCode.ERR001_UNIVERSITY_NOT_FOUND.getMessage(),
//                        universityCode
//                )))
//                ;
//    }
//
//    @Override
//    public UniversityResponseDTO deleteByCode(String universityCode) {
//        List<String> ids = new ArrayList<>();
//        ids.add(universityCode);
//
//        universityRepository.deleteAllByIdInBatch(ids);
//        return null;
//    }
}
