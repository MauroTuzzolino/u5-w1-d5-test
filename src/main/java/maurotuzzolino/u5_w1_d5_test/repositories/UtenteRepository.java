package maurotuzzolino.u5_w1_d5_test.repositories;

import maurotuzzolino.u5_w1_d5_test.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
    Optional<Utente> findByUsername(String username);
}
