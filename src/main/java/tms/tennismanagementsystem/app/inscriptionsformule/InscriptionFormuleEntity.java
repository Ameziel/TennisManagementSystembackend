package tms.tennismanagementsystem.app.inscriptionsformule;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tms.tennismanagementsystem.app.eleves.EleveEntity;
import tms.tennismanagementsystem.app.formulecours.FormuleCoursEntity;
import tms.tennismanagementsystem.app.groupescours.GroupeCoursEntity;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inscriptionsformule")
public class InscriptionFormuleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate datePaiement;
    private Double montantPercu;
    @Enumerated(EnumType.STRING)            //VIREMENT,LIQUIDE
    private MoyenPaiement moyenPaiement;
    private String notePaiement; //TODO Rajouter un champ, paiement complet ?
    @ManyToOne
    @JoinColumn(name = "reference_eleve")
    private EleveEntity referenceEleve;
    @ManyToOne
    @JoinColumn(name = "reference_formule")
    private FormuleCoursEntity referenceFormuleCours;
    @ManyToOne
    @JoinColumn(name = "reference_groupe")
    private GroupeCoursEntity referenceGroupe;


}
