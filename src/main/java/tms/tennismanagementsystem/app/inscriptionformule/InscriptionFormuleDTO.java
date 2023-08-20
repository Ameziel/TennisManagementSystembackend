package tms.tennismanagementsystem.app.inscriptionformule;

import lombok.Data;
import tms.tennismanagementsystem.app.eleves.EleveDTO;
import tms.tennismanagementsystem.app.formulecours.FormuleCoursDTO;
import tms.tennismanagementsystem.app.groupecours.GroupeCoursDTO;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class InscriptionFormuleDTO {
    private UUID id;
    private LocalDate datePaiement;
    private Double montantPercu;
    private String notePaiement;
    private MoyenPaiement moyenPaiement;
    private EleveDTO eleveDTO;
    private GroupeCoursDTO groupeCoursDTO;
    private FormuleCoursDTO formuleCoursDTO;
}
