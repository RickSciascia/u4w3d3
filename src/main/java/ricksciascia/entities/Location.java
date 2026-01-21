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
    private String city;
    @OneToMany(mappedBy = "locationEvento")
    private List<Evento> eventi;

//    costruttore vuoto per JPA
    public Location(){}

//    costruttore custom
    public Location(String nome, String city){
        this.nome = nome;
        this.city = city;
    }
//    GETTER e SETTER


    public long getLocationId() {
        return locationId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Evento> getEventi() {
        return eventi;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", nome='" + nome + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
