package maurotuzzolino.u5_w1_d5_test.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String indirizzo;
    private String citta;

    @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
    private List<Postazione> postazioni;

    public Edificio() {
    }

    public Edificio(String nome, String indirizzo, String citta, List<Postazione> postazioni) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.postazioni = postazioni;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public List<Postazione> getPostazioni() {
        return postazioni;
    }

    public void setPostazioni(List<Postazione> postazioni) {
        this.postazioni = postazioni;
    }

    @Override
    public String toString() {
        return "Edificio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", citta='" + citta + '\'' +
                ", postazioni=" + postazioni +
                '}';
    }
}
