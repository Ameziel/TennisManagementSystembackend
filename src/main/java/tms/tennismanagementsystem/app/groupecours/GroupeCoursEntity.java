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
@Table(name = "groupescours")
public class GroupeCoursEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String libelle; //Plutot une clé étrangère sur la formule
    @Enumerated(EnumType.STRING)
    private Jour jour1;
    @Enumerated(EnumType.STRING)
    private Jour jour2;
    private boolean actif;
    @ManyToOne
    private MoniteurEntity moniteurResponsable;
    @OneToOne(mappedBy = "referenceGroupe")
    private InscriptionFormuleEntity inscriptionFormuleEntity;
}
