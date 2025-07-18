package maurotuzzolino.u5_w1_d5_test.services;

import maurotuzzolino.u5_w1_d5_test.entities.Utente;
import maurotuzzolino.u5_w1_d5_test.repositories.UtenteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtenteService {

    private final UtenteRepository utenteRepository;

    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public Utente salva(Utente utente) {
        return utenteRepository.save(utente);
    }

    public Optional<Utente> trovaPerUsername(String username) {
        return utenteRepository.findByUsername(username);
    }
}
