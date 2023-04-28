package tms.tennismanagementsystem.app.groupecours;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroupeCoursRepository extends JpaRepository<GroupeCoursEntity, UUID> {
}
