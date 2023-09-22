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
    List<EleveEntity> searchElevesByNames(@Param("keyword") String keyword);
    List<EleveEntity> findAllByActifTrue();
    List<EleveEntity> findAllByActifFalse();
    List<EleveEntity> findAllByEmail(String email);
    List<EleveEntity> findAllByOrderByNomAsc();
    List<EleveEntity> findAllByActifTrueOrderByNomAsc();
}
