package tms.tennismanagementsystem.app.formulecours;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class FormuleCoursDTO {
    private UUID id;
    private String libelle;
    private Integer effectifMaximum;
    private Integer nombreSeanceTotal;
    private Integer nombreSeanceHebdomadaire;
    private String dureeSeance; //1H ou 1H30
    private Double tarif;
    private Integer annee;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Periode periode;
    private TypeBalle typeBalle;
}





