package tms.tennismanagementsystem.app.moniteur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface MoniteurRepository extends JpaRepository<MoniteurEntity, UUID> {

    @Query("FROM MoniteurEntity m WHERE m.prenom like LOWER(:keyword) OR m.nom like LOWER(:keyword)")
    List<MoniteurEntity> searchMoniteursByName(@Param("keyword") String keyword);
}
