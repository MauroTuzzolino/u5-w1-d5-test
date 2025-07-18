package maurotuzzolino.u5_w1_d5_test.exceptions;

public class PostazioneNonTrovataException extends RuntimeException {
    public PostazioneNonTrovataException(Long id) {
        super("Postazione con ID " + id + " non trovata.");
    }
}
