package maurotuzzolino.u5_w1_d5_test.exceptions;

import java.time.LocalDate;

public class PostazioneNonDisponibileException extends RuntimeException {
    public PostazioneNonDisponibileException(Long id, LocalDate data) {
        super("La postazione con ID " + id + " non è disponibile per il giorno " + data + ".");
    }
}
