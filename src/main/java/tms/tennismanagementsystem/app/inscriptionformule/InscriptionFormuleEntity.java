package tms.tennismanagementsystem.app.inscriptionformule;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tms.tennismanagementsystem.app.formulecours.FormuleCoursEntity;
import tms.tennismanagementsystem.app.groupecours.GroupeCoursEntity;
import tms.tennismanagementsystem.app.student.EleveEntity;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inscriptionformule")
public class InscriptionFormuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate datePaiement;
    private Double acompte;
    @ManyToOne
    private EleveEntity referenceEleve;
    @OneToOne
    private GroupeCoursEntity referenceGroupe;
    @OneToOne
    private FormuleCoursEntity referenceFormule;

}
