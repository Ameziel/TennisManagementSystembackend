package tms.tennismanagementsystem.app.eleves;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EleveRepository extends JpaRepository<EleveEntity, UUID> {
    @Query("FROM EleveEntity e WHERE e.prenom like LOWER(:keyword) OR e.nom like LOWER(:keyword)")
    List<EleveEntity> searchElevesByName(@Param("keyword") String keyword);
    List<EleveDTO> findByEmail(@Param("email") String email);


    List<EleveDTO> findAllByActifTrue(); //TODO a corriger ne fonctionne pas

    @Query("FROM EleveEntity e WHERE e.actif = true")
    List<EleveEntity> findElevesActifs();
    List<EleveDTO> findAllByActifFalse();
}
