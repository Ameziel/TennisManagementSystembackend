package tms.tennismanagementsystem.app.formulecours;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tms.tennismanagementsystem.app.inscriptionformule.InscriptionFormuleEntity;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "formulescours")
public class FormuleCoursEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Integer effectifMaximum;
    private Integer nombreSeanceTotal;
    private Integer nombreSeanceHebdomadaire;
    private Integer dureeSeanceMinuteFormuleCours;
    private Double tarif;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    @Enumerated(EnumType.STRING)
    private CategorieAge categorieAge;  //ENFANT,JEUNE,ADOLESCENT,ADULTE
    @Enumerated(EnumType.STRING)
    private Periode periode;            //HIVER, ETE, ANNEE
    @Enumerated(EnumType.STRING)
    private TypeBalle typeBalle;        //ROUGE, ORANGE, VERTE, JAUNE
    @Enumerated(EnumType.STRING)
    private Niveau niveau;              //LOISIR, QUATRIEME_SERIE,TROISIEME_SERIE,DEUXIEME_SERIE
    private boolean actif;
    @OneToOne(mappedBy = "referenceFormule")
    private InscriptionFormuleEntity inscriptionFormuleEntity;

}
