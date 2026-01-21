package ricksciascia.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ricksciascia.entities.Location;
import ricksciascia.exceptions.NotFoundException;

public class LocationDAO {
    private final EntityManager entityManager;

    public LocationDAO(EntityManager em) {
        this.entityManager = em;
    }
//    metodi
    public void saveLocation(Location nuovaLocation) {
//        1) creare transazione con em
        EntityTransaction transaction = entityManager.getTransaction();
//        2) inizio transazione
        transaction.begin();
//        3)aggiungere la location alla PersistenceContext
        entityManager.persist(nuovaLocation);
//        4) commit della transazione
        transaction.commit();
//        5)
        System.out.println("Operazione di salvataggio Location: " + nuovaLocation.getNome() + " presso: " + nuovaLocation.getCity() + " avvenuta correttamente!");
    }
    public Location getLocationById(long id) {
        Location locationTrovata = entityManager.find(Location.class,id);
        if(locationTrovata == null) throw new NotFoundException(id);
        return locationTrovata;
    }

    public void deleteLocation(long id) {
//        1) cerco la location con metodo fatto prima
        Location locationDaCancellare = getLocationById(id);
//        2) creo transazione
        EntityTransaction transaction = entityManager.getTransaction();
//        3) avvio transazione
        transaction.begin();
//        4) metodo .remove()
        entityManager.remove(locationDaCancellare);
//        5) commit
        transaction.commit();
//        6)
        System.out.println("La location " + locationDaCancellare + " è stata eliminata correttamente!");

    }
}
