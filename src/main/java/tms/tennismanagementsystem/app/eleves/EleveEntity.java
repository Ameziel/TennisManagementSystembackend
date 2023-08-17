package tms.tennismanagementsystem.app.eleves;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tms.tennismanagementsystem.app.inscriptionformule.InscriptionFormuleEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "eleve")
public class EleveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String prenom;
    private String nom;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private String telephone;
    private String email;
    private LocalDate dateDeNaissance;
    private String details;
    private boolean actif;
    @OneToMany(mappedBy = "referenceEleve")
    private List<InscriptionFormuleEntity> inscriptionFormuleEntity;
    public EleveEntity(String prenom, String nom,String genre, String telephone, String email, LocalDate date, String details, boolean estActif) {
        this.prenom = prenom;
        this.nom = nom;
        this.genre = Genre.valueOf(genre);
        this.telephone = telephone;
        this.email = email;
        this.dateDeNaissance = date;
        this.details = details;
        this.actif = true;
    }

    public EleveEntity(String uuid, String s, String loremIpsum, String mail, String aTrue, String f, String addison, String mona, String s1) {
    }

    public EleveEntity(String margot, String iktoria, Genre genre, String telephone, String mail, LocalDate of, String loremIpsum, boolean estActif) {
    }

    public EleveEntity(String uuid, String margot, String iktoria, Genre genre, String aTrue, String mail, LocalDate of, String loremIpsum, boolean b) {
    }
}
