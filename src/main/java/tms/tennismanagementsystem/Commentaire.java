package tms.tennismanagementsystem;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String lecommentaire;
//    @OneToOne(mappedBy = "comments")// Le ERD dans pgadmin met un N côté produit et 1 côté ocmmentaire. Comme si plusieurs produits étaient liés à un commentaire
    @ManyToOne //Ici il fait la table d'association
    private Produit produit;
}
