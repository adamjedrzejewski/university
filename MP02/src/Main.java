import java.time.LocalDate;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // Binary association
        Package pkg = new Package(10);
        Shipment shipment = new Shipment(LocalDate.now());

        shipment.addPackage(pkg);
        System.out.println("Reverse connections:"
                + "\n\tshipment == pkg.getShipment(): " + (shipment == pkg.getShipment())
                + "\n\tpkg == shipment.getPackages().get(0) == pkg: " + (pkg == shipment.getPackages().get(0)));

        // Composition
        ChargeGroup chargeGroup = new ChargeGroup();
        Charge charge = new Charge(chargeGroup, "Taxes", 10);

        System.out.println("Reverse connections:"
                + "\n\tchargeGroup == charge.getChargeGroup(): " + (chargeGroup == charge.getChargeGroup()));

        // Qualified
        Shipment shipment1 = new Shipment(LocalDate.now());
        ChargeGroup accessorialChargeGroup = new ChargeGroup();
        ChargeGroup shippingChargeGroup = new ChargeGroup();
        Charge taxes = new Charge(accessorialChargeGroup, "Taxes", 10);
        Charge freightCharge = new Charge(shippingChargeGroup, "Shipping Charge", 50);

        shipment1.addChargeGroup("Accessorial Charges", accessorialChargeGroup);
        shipment1.addChargeGroup("Shipping Charges", shippingChargeGroup);

        for (Map.Entry<String, ChargeGroup> entry : shipment1.getChargeGroups().entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // with attribute
        Truck truck = new Truck("2139812083912", "6f16fa12-05be-41f5-a5c5-716042604911");
        Driver driver = new Driver("Michael", "Jackson", "763 636 272");
        TruckDriver truckDriver = new TruckDriver(LocalDate.now(), LocalDate.now().plusDays(7));
        truckDriver.setTruck(truck);
        truckDriver.setDriver(driver);

        System.out.println(truck.getDriver());
        System.out.println(driver.getTruck());
        System.out.println("Reverse connections:"
                + "\n\ttruck == driver.getTruck(): " + (truck == driver.getTruck())
                + "\n\tdriver == truck.getDriver(): " + (driver == truck.getDriver()));
    }
}

/*
    Composition
        one charge group must have at least one charge and may have multiple charges

    Qualified
        One shipment may have multiple charge groups
 */