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
    private boolean actif;

    public EleveDTO(String margot, String iktoria, Genre genre, String s, String mail, LocalDate of, String loremIpsum, boolean b) {
    }

    public EleveDTO() {
        
    }

    public EleveDTO(UUID uuid, String addison, String mona, Genre genre, String s, String mail, LocalDate of, String loremIpsum, boolean b) {
    }
}
