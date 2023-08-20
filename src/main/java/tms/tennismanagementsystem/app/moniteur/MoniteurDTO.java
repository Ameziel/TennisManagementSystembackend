package tms.tennismanagementsystem.app.moniteur;

import lombok.Data;

import java.util.UUID;

@Data
public class MoniteurDTO {
    private UUID id;
    private String prenom;
    private String nom;
    private String email;
    private String telephone;
    private QualificationMoniteur qualification;
    private boolean actif;

    public MoniteurDTO( ) {
    }

    public MoniteurDTO(UUID id, String prenom, String nom, String email, String telephone, QualificationMoniteur qualification, boolean actif) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.qualification = qualification;
        this.actif = actif;
    }
}
