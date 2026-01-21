package ricksciascia.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long partecipazioneId;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Stato stato;

//    COSTRUTTORE VUOTO
    public Partecipazione(){}
//    COSTRUTTORE custom
    public Partecipazione(Stato stato){
        this.stato = stato;
    }
}


