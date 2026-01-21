package ricksciascia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ricksciascia.dao.EventoDAO;
import ricksciascia.dao.LocationDAO;
import ricksciascia.entities.Evento;
import ricksciascia.entities.Location;
import ricksciascia.entities.TipoEvento;
import ricksciascia.exceptions.NotFoundException;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d3pu");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO ed = new EventoDAO(em);
        LocationDAO ld = new LocationDAO(em);

        Location sanSiro = new Location("San Siro", "Milano");
        Location palalottomatica = new Location("Pala Lottomatica", "Roma");

//        ld.saveLocation(sanSiro);
//        ld.saveLocation(palalottomatica);

        try{
            Location sSiroFromDB = ld.getLocationById(1);
            Location palalottomaticaFromDB = ld.getLocationById(2);
            Evento pupoARoma = new Evento("Pupo in tour", LocalDate.of(2026, 1, 20),"Incredibile di nuovo PUPO a ROMA", TipoEvento.PUBBLICO,30000,palalottomaticaFromDB);
            Evento pupoSSiro = new Evento("Pupo a S.Siro", LocalDate.of(2026, 1, 28),"Incredibile di nuovo PUPO a S.Siro", TipoEvento.PUBBLICO,50000,sSiroFromDB);
            Evento vascoSSiro = new Evento("Vasco Rossi a S.Siro", LocalDate.of(2026, 2, 28),"Vasco Rossi a S.Siro", TipoEvento.PUBBLICO,50000,sSiroFromDB);

            ed.saveEvento(pupoARoma);
            ed.saveEvento(pupoSSiro);
            ed.saveEvento(vascoSSiro);

            System.out.println(pupoARoma);
            System.out.println(pupoARoma.getLocationEvento());
            System.out.println(pupoSSiro);
            System.out.println(pupoSSiro.getLocationEvento());
            System.out.println(vascoSSiro);
            System.out.println(vascoSSiro.getLocationEvento());
        } catch(NotFoundException exception){
            System.out.println(exception.getMessage());
        }
        System.out.println("Hello World!");
    }
}
