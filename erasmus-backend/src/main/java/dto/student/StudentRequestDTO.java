package dto.student;

import dto.username.UserRequestDTO;

import java.util.UUID;

public class StudentRequestDTO extends UserRequestDTO {
    private int yearOfStudy; // an universitar
    private boolean hasLanguageCertificate;
    private float gpa; // medie generala
    private boolean hasReexaminations; // hasRestante?
}
