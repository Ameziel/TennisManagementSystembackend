package tms.tennismanagementsystem.app.inscriptionsformule;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InscriptionFormuleRepository extends JpaRepository<InscriptionFormuleEntity, UUID> {
}
