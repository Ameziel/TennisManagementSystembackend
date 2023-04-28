package tms.tennismanagementsystem.app.prestationcours;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PrestationCoursRepository extends JpaRepository<PrestationCoursEntity, UUID> {
}
