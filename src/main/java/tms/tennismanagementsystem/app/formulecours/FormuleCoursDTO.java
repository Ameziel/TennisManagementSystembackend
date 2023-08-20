package tms.tennismanagementsystem.app.formulecours;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class FormuleCoursDTO {
    private UUID id;
    private Integer effectifMaximum;
    private Integer nombreSeanceTotal;
    private Integer nombreSeanceHebdomadaire;
    private Integer dureeSeanceMinuteFormuleCours;
    private Double tarif;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private CategorieAge categorieAge;  //ENFANT,JEUNE,ADOLESCENT,ADULTE
    private Periode periode;            //HIVER, ETE, ANNEE
    private TypeBalle typeBalle;        //ROUGE, ORANGE, VERTE, JAUNE
    private Niveau niveau;              //LOISIR, QUATRIEME_SERIE,TROISIEME_SERIE,DEUXIEME_SERIE
    private boolean actif;
}





