package tms.tennismanagementsystem.app.moniteur;

import lombok.Data;

import java.util.UUID;

@Data
public class MoniteurDTO {
    private UUID id;
    private String prenom;
    private String nom;
    private String adresse;
    private String email;
    private String telephone;
    private QualificationMoniteur qualification;
    private boolean actif;
}
