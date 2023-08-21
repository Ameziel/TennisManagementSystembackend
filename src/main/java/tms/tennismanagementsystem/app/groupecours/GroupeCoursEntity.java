package tms.tennismanagementsystem.app.groupecours;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tms.tennismanagementsystem.app.inscriptionformule.InscriptionFormuleEntity;
import tms.tennismanagementsystem.app.prestationcours.PrestationCoursEntity;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "groupescours")
public class GroupeCoursEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String libelle;
    private boolean actif;
    @OneToMany
    private InscriptionFormuleEntity inscriptionFormuleEntity;
    @OneToMany
    private List<PrestationCoursEntity> prestationCoursEntityList;
}
