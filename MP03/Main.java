import dynamic.*;
import disjoint.*;
import abstractclass.*;
import multiinheritance.*;
import overlapping.*;

public class Main {

    public static void main(String[] args) {
        // Abstract class
        ShipmentService flatBed = new FlatBedShipment(20, 20, HazardousMaterialType.EXPLOSIVES);
        ShipmentService parcel = new ParcelShipment(13, 13, 13, 30, HazardousMaterialType.OXIDIZER);
        
        // Polymorphic methoda call
        System.out.println("POLIMORPHIC METHOD CALL");
        System.out.printf("Flatbed fee: %.2f\n", flatBed.getBaseFee());
        System.out.printf("Parcel fee: %.2f\n", parcel.getBaseFee());
    
        // Multi inhereitance
        HybridCar car = new HybridCar("jfksadjfklasjafdsk", 1.7, 90, 60, 200, 90);
        System.out.println("\nMULTI INHERITANCE");
        System.out.printf("Power: %.2f\n", car.getPower());
        System.out.printf("Battery capacity: %.2f\n", car.getBatteryCapacity());
        System.out.printf("Fuel tank capacity: %.2f\n", car.getFuelTankCapacity());
        System.out.printf("Engine displacement: %.2f\n", car.getEngineDisplacement());

        // Disjoint
        Manager manager = new Manager(
            "Michael", "Jackson",
            "JacksonMichael", 125000);
        IndividualContributor individualContributor = new IndividualContributor(
            "John", "Doe",
            "DoeJohn", 85000,
            "Software Engineer", Seniority.JUNIOR);

        manager.addSubordinate(individualContributor);
        
        System.out.println("\nDISJOINT");
        System.out.printf("Manager: %s %s\n", manager.getFirstName(), manager.getLastName());
        System.out.println("Subordiantes: " + manager.getSubordinates());
    
        try {
            // Dynamic
            Shipment shipment = new Shipment("nuldjkalsjdklasl");

            System.out.println("\nDYNAMIC");
            System.out.printf("Initial shipment status: %s\n", shipment.getLoadStatus());
            shipment.goToPickLocation();
            shipment.loadShipment();
            System.out.printf("Shipment status after loading: %s\n", shipment.getLoadStatus());
            shipment.goToDropLocation();
            System.out.printf("Shipment status after going to drop location: %s\n", shipment.getLoadStatus());
        } catch (LoadException exception) {
            exception.printStackTrace();
        }

        // Overlapping
        Person person0 = new Person(0, 2, 27);
        Person person1 = new Person(0, 0, 22);
        Person person2 = new Person(14, 0, 33);

        System.out.println("\nOVERLAPPING");
        System.out.printf("Tax on 27 year old with 2 children, 94000 income: %.2f\n", person0.getTaxOnIncome(94000));
        System.out.printf("Tax on 22 year old with 0 children, 55000 income: %.2f\n", person1.getTaxOnIncome(55000));
        System.out.printf("Tax on 33 year old with 0 children, 14 years of service, 200000 income: %.2f\n", person2.getTaxOnIncome(200000));
    }

}

/* Multiaspect
 */
