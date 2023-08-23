package tms.tennismanagementsystem.app.inscriptionsformule;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class InscriptionFormuleDTO {
    private UUID id;
    private LocalDate datePaiement;
    private Double montantPercu;
    private String notePaiement;
    private MoyenPaiement moyenPaiement;
    private UUID referenceEleve;
    private UUID referenceGroupeCours;
    private UUID referenceFormuleCours;
}
