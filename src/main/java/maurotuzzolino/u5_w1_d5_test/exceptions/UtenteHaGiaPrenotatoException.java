package maurotuzzolino.u5_w1_d5_test.exceptions;

import java.time.LocalDate;

public class UtenteHaGiaPrenotatoException extends RuntimeException {
    public UtenteHaGiaPrenotatoException(String username, LocalDate data) {
        super("L'utente '" + username + "' ha già una prenotazione per il giorno " + data + ".");
    }
}
