package tms.tennismanagementsystem.app.groupecours;

import lombok.Data;

import java.util.UUID;

@Data
public class GroupeCoursDTO {
    private UUID id;
    private String libelle;
    private Jour jour1;
    private Jour jour2;
}
