package tms.tennismanagementsystem.app.prestationcours;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class PrestationCoursDTO {
    private UUID id;
    private LocalDate datePrestation;
    private Double coefficientDuree;
    private String commentaire;
}
