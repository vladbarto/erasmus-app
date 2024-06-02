package ro.tucn.erasmusbackend.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementRequestDTO;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementResponseDTO;
import ro.tucn.erasmusbackend.model.AnnouncementEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AnnouncementMapperTest {

    private AnnouncementMapper underTest;

    private static final UUID ANNOUNCEMENT_ID = UUID.fromString("00000000-0000-0000-0000-000000000000");
    public static final UUID REPRESENTATIVE_ID = UUID.fromString("10000000-0000-0000-0000-000000000000");

    @BeforeEach
    void setUp() { underTest = Mappers.getMapper(AnnouncementMapper.class); }

    @Test
    @DisplayName(value = "This test should return equals when an entity is converted to a response dto")
    void givenValidAnnouncementEntity_whenMapperCalled_thenReturnValidAnnouncementResponseDTO() {
        final var request = getAnnouncementEntity();
        final var expected = getAnnouncementResponseDTO();

        final var response = underTest.announcementEntityToAnnouncementResponseDTO(request);

        assertThat(response).isEqualTo(expected);
    }

    @Test
    @DisplayName(value = "This test should return equals when a list of entities is converted to a list of response dtos")
    void givenValidAnnouncementEntityList_whenMapperCalled_thenReturnValidAnnouncementResponseDTOList() {
        final var request = getAnnouncementEntityList();
        final var expected = getAnnouncementResponseDTOList();

        final var response = underTest.announcementEntityListToAnnouncementResponseDTOList(request);

        assertThat(response).isEqualTo(expected);
    }

    @Test
    @DisplayName(value = "This test should return equals when a request dto is converted to an entity")
    void givenValidAnnouncementRequestDTO_whenMapperCalled_thenReturnValidAnnouncementEntity() {
        final var request = getAnnouncementRequestDTO();
        final var expected = getAnnouncementEntityWithoutId();

        final var response = underTest.announcementRequestDTOToAnnouncementEntity(request);

        assertThat(response).isEqualTo(expected);
    }

    // for test 1
    private AnnouncementEntity getAnnouncementEntity() {
        return AnnouncementEntity.builder()
                .announcementId(ANNOUNCEMENT_ID)
                .title("Stiri Erasmus")
                .description("S-a publicat lista cu studentii admisi.")
                .representativeId(REPRESENTATIVE_ID)
                .universityCode("UTCN_01")
                .build();
    }

    private AnnouncementResponseDTO getAnnouncementResponseDTO() {
        return AnnouncementResponseDTO.builder()
                .announcementId(ANNOUNCEMENT_ID)
                .title("Stiri Erasmus")
                .description("S-a publicat lista cu studentii admisi.")
                .representativeId(REPRESENTATIVE_ID)
                .universityCode("UTCN_01")
                .build();
    }

    // for test 2
    private List<AnnouncementEntity> getAnnouncementEntityList() {
        AnnouncementEntity entity1 = AnnouncementEntity.builder()
                .title("Stiri Erasmus")
                .description("S-a publicat lista cu studentii admisi.")
                .representativeId(REPRESENTATIVE_ID)
                .universityCode("UTCN_01")
                .build();

        AnnouncementEntity entity2 = AnnouncementEntity.builder()
                .title("Update Erasmus")
                .description("Rectificari aduse documentelor necesare.")
                .representativeId(REPRESENTATIVE_ID)
                .universityCode("UTCN_01")
                .build();

        ArrayList<AnnouncementEntity> list = new ArrayList<>();
        list.add(entity1);
        list.add(entity2);

        return list;
    }

    private List<AnnouncementResponseDTO> getAnnouncementResponseDTOList() {
        AnnouncementResponseDTO entity1 = AnnouncementResponseDTO.builder()
                .title("Stiri Erasmus")
                .description("S-a publicat lista cu studentii admisi.")
                .representativeId(REPRESENTATIVE_ID)
                .universityCode("UTCN_01")
                .build();

        AnnouncementResponseDTO entity2 = AnnouncementResponseDTO.builder()
                .title("Update Erasmus")
                .description("Rectificari aduse documentelor necesare.")
                .representativeId(REPRESENTATIVE_ID)
                .universityCode("UTCN_01")
                .build();

        ArrayList<AnnouncementResponseDTO> list = new ArrayList<>();
        list.add(entity1);
        list.add(entity2);

        return list;
    }

    // for test 3
    private AnnouncementEntity getAnnouncementEntityWithoutId() {
        return AnnouncementEntity.builder()
                .title("Stiri Erasmus")
                .description("S-a publicat lista cu studentii admisi.")
                .representativeId(REPRESENTATIVE_ID)
                .universityCode("UTCN_01")
                .build();
    }

    private AnnouncementRequestDTO getAnnouncementRequestDTO() {
        return AnnouncementRequestDTO.builder()
                .title("Stiri Erasmus")
                .description("S-a publicat lista cu studentii admisi.")
                .representativeId(REPRESENTATIVE_ID)
                .universityCode("UTCN_01")
                .build();
    }
}
