package tms.tennismanagementsystem.app.student;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tms.tennismanagementsystem.app.inscriptionformule.InscriptionFormuleEntity;

import java.time.LocalDateTime;
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
    private String telephone;
    private String email;
    private LocalDateTime dateDeNaissance;
    private String details;
    @OneToMany(mappedBy = "referenceEleve")
    private List<InscriptionFormuleEntity> inscriptionFormuleEntity;
    public EleveEntity(String prenom, String nom, String telephone, String email, LocalDateTime date) {
        this.prenom = prenom;
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.dateDeNaissance = date;
    }
}
