package tms.tennismanagementsystem.app.formule;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tms.tennismanagementsystem.app.inscriptionformule.InscriptionFormuleEntity;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "formulecours")
public class FormuleCoursEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String libelle;

    private int effectifMaximum;

    private int nombreSeance;

    private double tarif;

    private String annee;

    private String saison; //peut etre une enumeration : hiver, ete, annee

    @OneToOne(mappedBy = "referenceFormule")
    private InscriptionFormuleEntity inscriptionFormuleEntity;
}
