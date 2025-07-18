package maurotuzzolino.u5_w1_d5_test.runners;


import maurotuzzolino.u5_w1_d5_test.services.EdificioService;
import maurotuzzolino.u5_w1_d5_test.services.PostazioneService;
import maurotuzzolino.u5_w1_d5_test.services.PrenotazioneService;
import maurotuzzolino.u5_w1_d5_test.services.UtenteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeederRunner implements CommandLineRunner {

    private final EdificioService edificioService;
    private final PostazioneService postazioneService;
    private final UtenteService utenteService;
    private final PrenotazioneService prenotazioneService;

    public DatabaseSeederRunner(
            EdificioService edificioService,
            PostazioneService postazioneService,
            UtenteService utenteService,
            PrenotazioneService prenotazioneService
    ) {
        this.edificioService = edificioService;
        this.postazioneService = postazioneService;
        this.utenteService = utenteService;
        this.prenotazioneService = prenotazioneService;
    }

    @Override
    public void run(String... args) throws Exception {
//        // === CREAZIONE EDIFICI ===
//        Edificio roma = edificioService.salva(new Edificio("Sede Roma", "Via Verdi 1", "Roma", new ArrayList<>()));
//        Edificio milano = edificioService.salva(new Edificio("Sede Milano", "Via Manzoni 2", "Milano", new ArrayList<>()));
//        Edificio torino = edificioService.salva(new Edificio("Sede Torino", "Corso Francia 100", "Torino", new ArrayList<>()));
//
//        // === CREAZIONE POSTAZIONI ===
//        List<Postazione> postazioni = new ArrayList<>();
//        postazioni.add(postazioneService.salva(new Postazione("Privata 1", TipoPostazione.PRIVATO, 1, roma, new ArrayList<>())));
//        postazioni.add(postazioneService.salva(new Postazione("Sala Riunioni 1", TipoPostazione.SALA_RIUNIONI, 10, roma, new ArrayList<>())));
//        postazioni.add(postazioneService.salva(new Postazione("Open Space 1", TipoPostazione.OPENSPACE, 6, milano, new ArrayList<>())));
//        postazioni.add(postazioneService.salva(new Postazione("Privata 2", TipoPostazione.PRIVATO, 1, milano, new ArrayList<>())));
//        postazioni.add(postazioneService.salva(new Postazione("Open Space 2", TipoPostazione.OPENSPACE, 8, torino, new ArrayList<>())));
//
//        // === CREAZIONE UTENTI ===
//        Utente mario = utenteService.salva(new Utente("mrossi", new ArrayList<>(), "mario.rossi@example.com", "Mario Rossi"));
//        Utente luca = utenteService.salva(new Utente("lbianchi", new ArrayList<>(), "luca.bianchi@example.com", "Luca Bianchi"));
//        Utente anna = utenteService.salva(new Utente("averdi", new ArrayList<>(), "anna.verdi@example.com", "Anna Verdi"));
//
//        // === CREAZIONE PRENOTAZIONI ===
//        LocalDate oggi = LocalDate.now();
//        LocalDate domani = oggi.plusDays(1);
//        LocalDate dopodomani = oggi.plusDays(2);
//
//        try {
//            prenotazioneService.prenota(postazioni.get(0), mario, oggi);
//            prenotazioneService.prenota(postazioni.get(1), luca, oggi);
//            prenotazioneService.prenota(postazioni.get(2), anna, oggi);
//
//            prenotazioneService.prenota(postazioni.get(3), mario, domani);
//            prenotazioneService.prenota(postazioni.get(4), luca, domani);
//            prenotazioneService.prenota(postazioni.get(0), anna, dopodomani);
//        } catch (RuntimeException e) {
//            System.out.println("Errore in una prenotazione: " + e.getMessage());
//        }
//
//        System.out.println("Dati iniziali caricati con successo.");
    }
}
