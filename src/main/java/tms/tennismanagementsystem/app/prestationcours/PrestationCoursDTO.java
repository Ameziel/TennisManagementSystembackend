package tms.tennismanagementsystem.app.prestationcours;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class PrestationCoursDTO {
    private UUID id;
    private LocalDate datePrestation;
    private Integer dureeSeanceMinutePrestation;
    private String commentaire;
    private UUID referenceMoniteur; //TODO FIX
}
