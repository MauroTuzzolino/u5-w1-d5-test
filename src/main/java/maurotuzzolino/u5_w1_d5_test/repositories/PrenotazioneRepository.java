package maurotuzzolino.u5_w1_d5_test.repositories;

import maurotuzzolino.u5_w1_d5_test.entities.Postazione;
import maurotuzzolino.u5_w1_d5_test.entities.Prenotazione;
import maurotuzzolino.u5_w1_d5_test.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate data);

    boolean existsByUtenteAndDataPrenotazione(Utente utente, LocalDate data);
}
