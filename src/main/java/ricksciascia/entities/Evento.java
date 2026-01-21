package ricksciascia.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="eventi")
public class Evento {
    @Id // NOTAZIONE OBBLIGATORIA, devo dichiarare qual'è la PrimaryKey di questa tabella che verrà creata
    @GeneratedValue(strategy = GenerationType.IDENTITY) // opzionale ma consigliata delego il DB a generare l ID
    private long id;
    @Column(name = "titolo_evento",nullable = false, length = 30)
    private String titolo;
    @Column(name="data_evento",nullable = false)
    private LocalDate dataEvento;
    @Column(name="descrizione",nullable = false, length = 300)
    private String descrizione;
    @Column(name = "tipo_evento", nullable = false)
    @Enumerated(EnumType.STRING) // serve per gli enum se non vogliamo che siano convertiti in smallint come formato in DB
    private TipoEvento tipoEvento;
    @Column(name = "numero_massimo_partecipanti", nullable = false)
    private int numeroMassimoPartecipanti;
    @ManyToOne
    @JoinColumn(name="location_id", nullable = false)
    private Location locationEvento;
}
