package tms.tennismanagementsystem.app.eleves;

import lombok.Data;

import java.time.LocalDate;
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
