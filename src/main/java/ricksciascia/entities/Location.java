package ricksciascia.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private long locationId;
    private String nome;
    private String città;
    @OneToMany(mappedBy = "locationEvento")
    private List<Evento> eventi;
}
