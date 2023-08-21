package tms.tennismanagementsystem.app.inscriptionformule;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tms.tennismanagementsystem.app.eleves.EleveEntity;
import tms.tennismanagementsystem.app.formulecours.FormuleCoursEntity;
import tms.tennismanagementsystem.app.groupecours.GroupeCoursEntity;

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
    private String notePaiement;
    @ManyToOne
//    @JoinColumn(name = "reference_eleve")
    private EleveEntity referenceEleve;
    @OneToOne
    @JoinColumn(name = "reference_formule")
    private FormuleCoursEntity referenceFormule;
    @ManyToOne
    @JoinColumn(name = "reference_groupe")
    private GroupeCoursEntity referenceGroupe;


}
