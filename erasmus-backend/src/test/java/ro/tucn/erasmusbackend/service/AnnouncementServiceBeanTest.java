package ro.tucn.erasmusbackend.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementRequestDTO;
import ro.tucn.erasmusbackend.dto.announcement.AnnouncementResponseDTO;
import ro.tucn.erasmusbackend.exception.NotFoundException;
import ro.tucn.erasmusbackend.mapper.AnnouncementMapper;
import ro.tucn.erasmusbackend.model.AnnouncementEntity;
import ro.tucn.erasmusbackend.repository.AnnouncementRepository;
import ro.tucn.erasmusbackend.service.announcement.AnnouncementServiceBean;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static ro.tucn.erasmusbackend.mapper.AnnouncementMapperTest.REPRESENTATIVE_ID;

@SpringBootTest
class AnnouncementServiceBeanTest {
    private static final UUID ANNOUNCEMENT_ID = UUID.randomUUID();

    private AnnouncementServiceBean underTest;

    @Mock
    private AnnouncementRepository announcementRepositoryMock;

    @Mock
    private AnnouncementMapper announcementMapperMock;

    @BeforeEach
    void setUp() {
        this.underTest = new AnnouncementServiceBean(
                announcementRepositoryMock,
                announcementMapperMock,
                null
        );
    }

    @Test
    @DisplayName(value = "For a valid Id the existing object should update according to the valid request dto")
    void givenValidAnnouncementIdAndAnnouncementRequestDTO_whenUpdateIsCalled_thenReturnAnnouncementResponseDTO() {
        final var announcementEntity = getAnnouncementEntity();
        final var announcementResponseDTO = getAnnouncementResponseDTO();
        final var announcementRequestDTO = getAnnouncementRequestDTO();

        when(announcementRepositoryMock.findById(any(UUID.class))).thenReturn(Optional.of(announcementEntity));
        when(announcementRepositoryMock.save(any(AnnouncementEntity.class))).thenReturn(announcementEntity);
        when(announcementMapperMock.announcementEntityToAnnouncementResponseDTO(any(AnnouncementEntity.class))).thenReturn(announcementResponseDTO);

        final var response = underTest.update(announcementRequestDTO, ANNOUNCEMENT_ID);

        assertThat(response).isEqualTo(announcementResponseDTO);
        verify(announcementRepositoryMock).findById(any(UUID.class));
        verify(announcementMapperMock).announcementEntityToAnnouncementResponseDTO(any(AnnouncementEntity.class));
    }

    @Test
    @DisplayName(value = "For an invalid Id the update request should fail, regardless the request dto")
    void givenInvalidAnnouncementId_whenUpdateIsCalled_thenThrowException() {
        when(announcementRepositoryMock.findById(any(UUID.class))).thenReturn(Optional.empty());

        assertThatThrownBy(() -> underTest.update(any(AnnouncementRequestDTO.class), ANNOUNCEMENT_ID))
                .isInstanceOf(NotFoundException.class);
        verify(announcementRepositoryMock).findById(any(UUID.class));
        verify(announcementMapperMock, never()).announcementEntityToAnnouncementResponseDTO(any(AnnouncementEntity.class));
    }

    private AnnouncementEntity getAnnouncementEntity() {
        return AnnouncementEntity.builder()
                .announcementId(ANNOUNCEMENT_ID)
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

    private AnnouncementResponseDTO getAnnouncementResponseDTO() {
        return AnnouncementResponseDTO.builder()
                .announcementId(ANNOUNCEMENT_ID)
                .title("Stiri Erasmus")
                .description("S-a publicat lista cu studentii admisi.")
                .representativeId(REPRESENTATIVE_ID)
                .universityCode("UTCN_01")
                .build();
    }
}
