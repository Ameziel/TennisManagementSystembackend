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

}
