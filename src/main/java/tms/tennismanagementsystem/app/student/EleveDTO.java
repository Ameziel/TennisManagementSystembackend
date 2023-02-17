package tms.tennismanagementsystem.app.student;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class EleveDTO {
    private UUID id;
    private String prenom;
    private String nom;
    private String telephone;
    private String email;
    private LocalDateTime dateDeNaissance;
    private String details;
}