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
@Table(name = "formulecours")
public class FormuleCoursEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String libelle;
    private Integer effectifMaximum;
    private Integer nombreSeanceTotal;
    private Integer nombreSeanceHebdomadaire;
    private Integer dureeSeanceMinute;
    private Double tarif;
    private Integer annee;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    @Enumerated(EnumType.STRING) // HIVER, ETE, ANNEE
    private Periode periode;
    @Enumerated(EnumType.STRING)
    private TypeBalle typeBalle;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    private boolean actif;
    @OneToOne(mappedBy = "referenceFormule")
    private InscriptionFormuleEntity inscriptionFormuleEntity;
    public FormuleCoursEntity(String libelle, int effectifMaximum, int nombreSeanceTotal, int nombreSeanceHebdomadaire,
                              Integer dureeSeance, double tarif, int annee, LocalDate dateDebut, LocalDate dateFin, Periode periode, TypeBalle typeBalle) {
        this.libelle = libelle;
        this.effectifMaximum = effectifMaximum;
        this.nombreSeanceTotal = nombreSeanceTotal;
        this.nombreSeanceHebdomadaire = nombreSeanceHebdomadaire;
        this.dureeSeanceMinute = dureeSeance;
        this.tarif = tarif;
        this.annee = annee;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.periode = periode;
        this.typeBalle = typeBalle;
    }
}
