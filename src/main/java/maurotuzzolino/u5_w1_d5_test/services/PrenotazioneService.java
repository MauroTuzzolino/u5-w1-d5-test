package maurotuzzolino.u5_w1_d5_test.services;

import maurotuzzolino.u5_w1_d5_test.entities.Postazione;
import maurotuzzolino.u5_w1_d5_test.entities.Prenotazione;
import maurotuzzolino.u5_w1_d5_test.entities.Utente;
import maurotuzzolino.u5_w1_d5_test.repositories.PrenotazioneRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrenotazioneService {


    private final PrenotazioneRepository prenotazioneRepository;

    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    public boolean postazioneDisponibile(Postazione postazione, LocalDate data) {
        return !prenotazioneRepository.existsByPostazioneAndDataPrenotazione(postazione, data);
    }

    public boolean utenteHaGiaPrenotatoQuelGiorno(Utente utente, LocalDate data) {
        return prenotazioneRepository.existsByUtenteAndDataPrenotazione(utente, data);
    }

    public Prenotazione prenota(Postazione postazione, Utente utente, LocalDate data) {
        if (!postazioneDisponibile(postazione, data)) {
            throw new RuntimeException("Postazione già prenotata per il giorno " + data);
        }

        if (utenteHaGiaPrenotatoQuelGiorno(utente, data)) {
            throw new RuntimeException("Utente ha già una prenotazione per il giorno " + data);
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDataPrenotazione(data);
        prenotazione.setUtente(utente);
        prenotazione.setPostazione(postazione);

        return prenotazioneRepository.save(prenotazione);
    }
}
