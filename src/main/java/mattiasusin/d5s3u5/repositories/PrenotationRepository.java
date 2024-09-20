package mattiasusin.d5s3u5.repositories;

import mattiasusin.d5s3u5.entities.Prenotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PrenotationRepository extends JpaRepository<Prenotation, UUID> {
}
