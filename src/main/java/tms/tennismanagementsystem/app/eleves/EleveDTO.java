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



    public EleveDTO() {
    }

    public EleveDTO(String prenom, String nom, Genre genre, String telephone, String email, LocalDate dateDeNaissance, String details, boolean actif) {
        this.prenom = prenom;
        this.nom = nom;
        this.genre = genre;
        this.telephone = telephone;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
        this.details = details;
        this.actif = actif;
    }

    public EleveDTO(UUID id, String prenom, String nom, Genre genre, String telephone, String email, LocalDate dateDeNaissance, String details, boolean actif) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.genre = genre;
        this.telephone = telephone;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
        this.details = details;
        this.actif = actif;
    }


    public EleveDTO(String uuid, String margot, String iktoria, Genre genre, String telephone, String mail, LocalDate of, String loremIpsum, boolean actif) {
    }
}
