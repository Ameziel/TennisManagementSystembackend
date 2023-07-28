package tms.tennismanagementsystem.app.moniteur;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tms.tennismanagementsystem.app.groupecours.GroupeCoursEntity;
import tms.tennismanagementsystem.app.prestationcours.PrestationCoursEntity;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "moniteur")
public class MoniteurEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String prenom;
    private String nom;
    private String email;
    private String telephone;
    @Enumerated(EnumType.STRING)
    private QualificationMoniteur qualification;
    private boolean actif;
    @OneToMany(mappedBy = "moniteurResponsable")
    private List<GroupeCoursEntity> groupesCours;
    @OneToMany(mappedBy = "referenceMoniteur")
    private List<PrestationCoursEntity> prestationsCours;

    public MoniteurEntity(String prenom, String nom, String email, String telephone, QualificationMoniteur qualification) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.qualification = qualification;
    }
}
