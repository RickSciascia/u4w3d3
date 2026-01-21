package ricksciascia.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "persone")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personaId;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;
    @Column(nullable = false)
    private String email;
    @Column(name = "data_di_nascita", nullable = false)
    private LocalDate dataDiNascita;
    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
