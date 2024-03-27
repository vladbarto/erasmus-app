package dto.student;

import dto.username.UserResponseDTO;

import java.util.UUID;

public class StudentResponseDTO extends UserResponseDTO {
    private int matriculationNumber;
    private int yearOfStudy; // an universitar
    private boolean hasLanguageCertificate;
    private float gpa; // medie generala
    private boolean hasReexaminations; // hasRestante?

}
