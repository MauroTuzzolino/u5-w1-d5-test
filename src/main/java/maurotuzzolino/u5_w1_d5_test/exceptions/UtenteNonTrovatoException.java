package maurotuzzolino.u5_w1_d5_test.exceptions;

public class UtenteNonTrovatoException extends RuntimeException {
    public UtenteNonTrovatoException(String username) {
        super("Utente con username '" + username + "' non trovato.");
    }
}
