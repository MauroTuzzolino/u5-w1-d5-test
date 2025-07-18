package maurotuzzolino.u5_w1_d5_test.services;

import maurotuzzolino.u5_w1_d5_test.entities.Postazione;
import maurotuzzolino.u5_w1_d5_test.enums.TipoPostazione;
import maurotuzzolino.u5_w1_d5_test.repositories.PostazioneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    private final PostazioneRepository postazioneRepository;

    public PostazioneService(PostazioneRepository postazioneRepository) {
        this.postazioneRepository = postazioneRepository;
    }

    public Postazione salva(Postazione postaizone) {
        return postazioneRepository.save(postaizone);
    }

    public Postazione getById(Long id) {
        return postazioneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Postazione non trovata"));
    }

    public List<Postazione> trovaTutti() {
        return postazioneRepository.findAll();
    }

    public List<Postazione> cercaPerTipoECitta(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
    }

}
