package tms.tennismanagementsystem.app.student;

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
    @OneToMany(mappedBy = "referenceEleve")
    private List<InscriptionFormuleEntity> inscriptionFormuleEntity;
    public EleveEntity(String prenom, String nom,String genre, String telephone, String email, LocalDate date) {
        this.prenom = prenom;
        this.nom = nom;
        this.genre = Genre.valueOf(genre);
        this.telephone = telephone;
        this.email = email;
        this.dateDeNaissance = date;
    }
}
