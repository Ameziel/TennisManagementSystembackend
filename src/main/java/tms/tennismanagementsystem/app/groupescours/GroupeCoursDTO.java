package tms.tennismanagementsystem.app.groupescours;

import lombok.Data;

import java.util.UUID;

@Data
public class GroupeCoursDTO {
    private UUID id;
    private String libelle;
    private boolean actif;
}
