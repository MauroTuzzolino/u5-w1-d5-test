package maurotuzzolino.u5_w1_d5_test.services;

import maurotuzzolino.u5_w1_d5_test.entities.Postazione;
import maurotuzzolino.u5_w1_d5_test.entities.Prenotazione;
import maurotuzzolino.u5_w1_d5_test.entities.Utente;
import maurotuzzolino.u5_w1_d5_test.exceptions.PostazioneNonDisponibileException;
import maurotuzzolino.u5_w1_d5_test.exceptions.UtenteHaGiaPrenotatoException;
import maurotuzzolino.u5_w1_d5_test.repositories.PrenotazioneRepository;
import maurotuzzolino.u5_w1_d5_test.repositories.UtenteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {


    private final PrenotazioneRepository prenotazioneRepository;
    private final UtenteRepository utenteRepository;

    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository, UtenteRepository utenteRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
        this.utenteRepository = utenteRepository;
    }

    public boolean postazioneDisponibile(Postazione postazione, LocalDate data) {
        return !prenotazioneRepository.existsByPostazioneAndDataPrenotazione(postazione, data);
    }

    public boolean utenteHaGiaPrenotatoQuelGiorno(Utente utente, LocalDate data) {
        return prenotazioneRepository.existsByUtenteAndDataPrenotazione(utente, data);
    }

    public Prenotazione prenota(Postazione postazione, Utente utente, LocalDate data) {
        if (!postazioneDisponibile(postazione, data)) {
            throw new PostazioneNonDisponibileException(postazione.getId(), data);
        }

        if (utenteHaGiaPrenotatoQuelGiorno(utente, data)) {
            throw new UtenteHaGiaPrenotatoException(utente.getUsername(), data);
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDataPrenotazione(data);
        prenotazione.setUtente(utente);
        prenotazione.setPostazione(postazione);

        return prenotazioneRepository.save(prenotazione);
    }

    public List<Prenotazione> prenotazioniPerUtente(String username) {
        return prenotazioneRepository.findByUtenteWithPostazione(username);
    }
}
