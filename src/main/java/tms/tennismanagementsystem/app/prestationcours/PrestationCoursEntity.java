package tms.tennismanagementsystem.app.prestationcours;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tms.tennismanagementsystem.app.groupecours.GroupeCoursEntity;
import tms.tennismanagementsystem.app.moniteur.MoniteurEntity;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prestationcours")
public class PrestationCoursEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private GroupeCoursEntity referenceGroupe;

    @ManyToOne
    private MoniteurEntity referenceMoniteur;

    private LocalDateTime datePrestation;

    private Double coefficientDuree; //Voir comment dire 1h ou 1h30, peut etre en duree minute ?

    private String commentaire;

    //On pourra rajouter les absents par cours

}
