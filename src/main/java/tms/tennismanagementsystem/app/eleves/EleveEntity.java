package tms.tennismanagementsystem.app.eleves;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tms.tennismanagementsystem.app.inscriptionsformule.InscriptionFormuleEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "eleves")
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
    public EleveEntity(String prenom, String nom, Genre genre, String telephone, String email, LocalDate dateDeNaissance, String details, boolean actif) {
        this.prenom = prenom;
        this.nom = nom;
        this.genre = genre;
        this.telephone = telephone;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
        this.details = details;
        this.actif = actif;
    }
    public EleveEntity(UUID id, String prenom, String nom, Genre genre, String telephone, String email, LocalDate dateDeNaissance, String details, boolean actif) {
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
}
