import attribute.*;
import bag.*;
import custom.*;
import ordered.*;
import subset.*;
import unique.*;
import xor.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // XOR
        AirplaneRepairShop airplaneRepairShop = new AirplaneRepairShop("WAW", 404);
        CarRepairShop carRepairShop = new CarRepairShop("mączna 4 warszawa");
        try {
            new Mechanic("Michael", "Jackson", carRepairShop, airplaneRepairShop);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            new Mechanic("Michael", "Jackson", null, null);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        Mechanic mechanic = new Mechanic("Michael", "Jackson", null, airplaneRepairShop);
        System.out.printf("Is airplane mechanic: %b\n", mechanic.isAirplaneRepairShopMechanic());
        System.out.printf("Is car mechanic: %b\n", mechanic.isCarRepairShopMechanic());
        mechanic.setCarRepairShop(carRepairShop);
        System.out.printf("Is airplane mechanic: %b\n", mechanic.isAirplaneRepairShopMechanic());
        System.out.printf("Is car mechanic: %b\n", mechanic.isCarRepairShopMechanic());

        // UNIQUE
        try {
            new Car("90213801", "Honda", "Civic");
        } catch (UniqueException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            new Car("90213801", "Toyota", "Corolla");
        } catch (UniqueException exception) {
            System.out.println(exception.getMessage());
        }

        // SUBSET
        City nyc = new City("New York City");
        State ny = new State("NY");

        try {
            nyc.addLink(City.roleBelongsTo, State.roleConsistsOf, ny);
            nyc.addLink_subset(City.roleManages, State.roleManagedBy, City.roleBelongsTo, ny);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // ORDERED
        Playlist playlist = new Playlist("muzyka", new ArrayList<>());
        playlist.addSong(new Song("Beat it", "Michael Jackson", 300));
        playlist.addSong(new Song("Fairfax", "Steez83", 200));
        playlist.addSong(new Song("Unstoppable", "Sia", 400));
        
        // BAG
        Customer customer = new Customer("Mateo", "Mateo");
        Bank bank = new Bank("KJDS");
        Account account1 = new Account(customer, bank, "jladssalk", -10);
        Account account2 = new Account(customer, bank, "kjdsa", 100);
        
        // ATTRIBUTE
        try {
            new attribute.Dimensions(0, 0, 0);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            new Driver("afdsafas", "lkjadlks", "jkdssa", 12);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    
        // CUSTOM
        custom.Dimensions dim = new custom.Dimensions(1, 1, 1);
        try {
            new Load("nulsadkljasl", LocalDate.of(2022, 12, 18), dim);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
