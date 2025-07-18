package maurotuzzolino.u5_w1_d5_test.runners;

import maurotuzzolino.u5_w1_d5_test.entities.Postazione;
import maurotuzzolino.u5_w1_d5_test.entities.Prenotazione;
import maurotuzzolino.u5_w1_d5_test.entities.Utente;
import maurotuzzolino.u5_w1_d5_test.enums.TipoPostazione;
import maurotuzzolino.u5_w1_d5_test.services.PostazioneService;
import maurotuzzolino.u5_w1_d5_test.services.PrenotazioneService;
import maurotuzzolino.u5_w1_d5_test.services.UtenteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class RunnerApplicativo implements CommandLineRunner {

    private final Scanner scanner = new Scanner(System.in);
    private final UtenteService utenteService;
    private final PostazioneService postazioneService;
    private final PrenotazioneService prenotazioneService;
    private Utente utenteLoggato;

    public RunnerApplicativo(UtenteService utenteService,
                             PostazioneService postazioneService,
                             PrenotazioneService prenotazioneService) {
        this.utenteService = utenteService;
        this.postazioneService = postazioneService;
        this.prenotazioneService = prenotazioneService;
    }

    @Override
    public void run(String... args) {
        System.out.println("==== GESTIONE POSTAZIONI ====");
        loginUtente();

        int scelta = -1;
        while (scelta != 4) {
            stampaMenu();
            try {
                scelta = Integer.parseInt(scanner.nextLine());

                switch (scelta) {
                    case 1 -> ricercaPostazioni();
                    case 2 -> effettuaPrenotazione();
                    case 3 -> visualizzaPrenotazioni();
                    case 4 -> System.out.println("Uscita...");
                    default -> System.out.println("Scelta non valida");
                }
            } catch (Exception e) {
                System.out.println("Errore di input. Riprova.");
            }
        }
    }

    private void loginUtente() {
        System.out.print("Inserisci il tuo username: ");
        String username = scanner.nextLine();

        Optional<Utente> optUtente = utenteService.trovaPerUsername(username);
        if (optUtente.isPresent()) {
            utenteLoggato = optUtente.get();
            System.out.println("Benvenuto, " + utenteLoggato.getNomeCompleto());
        } else {
            System.out.println("Utente non trovato. Uscita...");
            System.exit(0);
        }
    }

    private void stampaMenu() {
        System.out.println("""
                    \nSeleziona un'opzione:
                    1. Cerca postazioni per tipo e città
                    2. Prenota una postazione
                    3. Visualizza le tue prenotazioni
                    4. Esci
                """);
    }

    private void ricercaPostazioni() {
        System.out.print("Inserisci tipo postazione (PRIVATO, OPENSPACE, SALA_RIUNIONI): ");
        TipoPostazione tipo = TipoPostazione.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Inserisci città: ");
        String citta = scanner.nextLine();

        List<Postazione> risultati = postazioneService.cercaPerTipoECitta(tipo, citta);
        if (risultati.isEmpty()) {
            System.out.println("Nessuna postazione trovata.");
        } else {
            risultati.forEach(p -> System.out.println("ID: " + p.getId() + " - " + p.getDescrizione()));
        }
    }

    private void effettuaPrenotazione() {
        System.out.print("Inserisci l'ID della postazione da prenotare: ");
        Long idPostazione = Long.parseLong(scanner.nextLine());

        System.out.print("Inserisci la data (AAAA-MM-GG): ");
        LocalDate data = LocalDate.parse(scanner.nextLine());

        try {
            Postazione postazione = postazioneService.getById(idPostazione);
            Prenotazione prenotazione = prenotazioneService.prenota(postazione, utenteLoggato, data);
            System.out.println("Prenotazione confermata: #" + prenotazione.getId() +
                    " per il " + prenotazione.getDataPrenotazione() +
                    " su postazione '" + prenotazione.getPostazione().getDescrizione() + "'");
        } catch (Exception e) {
            System.out.println("Errore durante la prenotazione: " + e.getMessage());
        }
    }

    private void visualizzaPrenotazioni() {
        List<Prenotazione> lista = prenotazioneService.prenotazioniPerUtente(utenteLoggato.getUsername());
        if (lista.isEmpty()) {
            System.out.println("Nessuna prenotazione trovata.");
        } else {
            lista.forEach(p -> System.out.printf("Prenotazione #%d per il %s su postazione '%s'%n",
                    p.getId(), p.getDataPrenotazione(), p.getPostazione().getDescrizione()));
        }
    }
}
