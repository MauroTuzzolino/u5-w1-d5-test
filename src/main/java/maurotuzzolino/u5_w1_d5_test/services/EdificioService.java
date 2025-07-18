package maurotuzzolino.u5_w1_d5_test.services;

import maurotuzzolino.u5_w1_d5_test.entities.Edificio;
import maurotuzzolino.u5_w1_d5_test.repositories.EdificioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {

    private final EdificioRepository edificioRepository;

    public EdificioService(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

    public Edificio salva(Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    public List<Edificio> trovaTutti() {
        return edificioRepository.findAll();
    }
}
