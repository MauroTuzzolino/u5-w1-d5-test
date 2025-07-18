package maurotuzzolino.u5_w1_d5_test.repositories;

import maurotuzzolino.u5_w1_d5_test.entities.Postazione;
import maurotuzzolino.u5_w1_d5_test.entities.Prenotazione;
import maurotuzzolino.u5_w1_d5_test.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate data);

    boolean existsByUtenteAndDataPrenotazione(Utente utente, LocalDate data);

    List<Prenotazione> findByUtente(Utente utente);


    @Query("SELECT p FROM Prenotazione p JOIN FETCH p.postazione WHERE p.utente.username = :username")
    List<Prenotazione> findByUtenteWithPostazione(@Param("username") String username);
}
