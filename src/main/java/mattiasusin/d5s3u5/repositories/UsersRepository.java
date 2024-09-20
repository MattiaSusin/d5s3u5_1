package mattiasusin.d5s3u5.repositories;

import mattiasusin.d5s3u5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<User,UUID> {
    Optional<User> findByEmail (String email);
}
