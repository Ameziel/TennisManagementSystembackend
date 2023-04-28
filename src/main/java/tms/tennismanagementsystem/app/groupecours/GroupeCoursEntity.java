package tms.tennismanagementsystem.app.groupecours;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tms.tennismanagementsystem.app.inscriptionformule.InscriptionFormuleEntity;
import tms.tennismanagementsystem.app.moniteur.MoniteurEntity;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "groupecours")
public class GroupeCoursEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String libelle;


    @Enumerated(EnumType.STRING)
    private Jour jour1;
    @Enumerated(EnumType.STRING)
    private Jour jour2;
    private ;

    @ManyToOne
    private MoniteurEntity moniteurResponsable; //inutile je pense
    @OneToOne(mappedBy = "referenceGroupe")
    private InscriptionFormuleEntity inscriptionFormuleEntity;
}
