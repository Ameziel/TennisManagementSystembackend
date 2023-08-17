package tms.tennismanagementsystem.app.prestationcours;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tms.tennismanagementsystem.app.groupecours.GroupeCoursEntity;
import tms.tennismanagementsystem.app.moniteur.MoniteurEntity;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prestationscours")
public class PrestationCoursEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate datePrestation;
    private Double coefficientDuree;
    private String commentaire;
    @ManyToOne
    private GroupeCoursEntity referenceGroupe;
    @ManyToOne
    private MoniteurEntity referenceMoniteur;
}
