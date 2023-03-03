package tms.tennismanagementsystem.app.student;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class EleveDTO {
    private UUID id;
    private String prenom;
    private String nom;
    private Genre genre;
    private String telephone;
    private String email;
    private LocalDate dateDeNaissance;
    private String details;
}
