package tms.tennismanagementsystem.app.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EleveRepository extends JpaRepository<EleveEntity, UUID> {
    @Query("FROM EleveEntity e WHERE e.prenom like :keyword OR e.nom like :keyword")
    List<EleveEntity> searchElevesByName(@Param("keyword") String keyword);

}
