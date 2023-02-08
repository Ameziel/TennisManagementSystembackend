package tms.tennismanagementsystem.app.inscriptionformule;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tms.tennismanagementsystem.app.formule.FormuleCoursEntity;
import tms.tennismanagementsystem.app.groupecours.GroupeCoursEntity;
import tms.tennismanagementsystem.app.student.EleveEntity;

import java.time.LocalDateTime;
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

    @ManyToOne
    private EleveEntity referenceEleve;

    @OneToOne
    private GroupeCoursEntity referenceGroupe;

    @OneToOne
    private FormuleCoursEntity referenceFormule;

    private LocalDateTime datePaiment;

    private Double accompte;

}
