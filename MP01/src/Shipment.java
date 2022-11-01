import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shipment implements Serializable {
    private LocalDate shipDate; // mandatory attribute
    private LocalDate deliveryDate; // optional attribute

    private final List<Package> packages = new ArrayList<>(); // multi value attribute
    private static List<Shipment> extent = new ArrayList<>(); // extent

    private void addToExtent() {
        extent.add(this);
    }

    private void removeFromExtent() {
        extent.remove(this);
    }

    public Shipment(LocalDate shipDate, LocalDate deliveryDate, List<Package> packages) {
        setShipDate(shipDate);
        setDeliveryDate(deliveryDate);

        this.packages.addAll(packages);
        addToExtent();
    }

    public Shipment(LocalDate shipDate, List<Package> packages) {
        setShipDate(shipDate);

        this.packages.addAll(packages);
        addToExtent();
    }

    public Shipment(LocalDate shipDate) {
        setShipDate(shipDate);
        addToExtent();
    }

    public void setShipDate(LocalDate shipDate) {
        if (shipDate == null) {
            throw new IllegalArgumentException("Ship date is required.");
        }
        this.shipDate = shipDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void addPackage(Package pkg) {
        packages.add(pkg);
    }

    public LocalDate getShipDate() {
        return shipDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public List<Package> getPackages() {
        return new ArrayList<>(packages);
    }

    @SuppressWarnings("unchecked")
    public static void loadExtent(ObjectInputStream in) throws IOException, ClassNotFoundException {
        extent = (ArrayList<Shipment>) in.readObject();
    }

    public static void saveExtent(ObjectOutputStream out) throws IOException{
        out.writeObject(extent);
    }

    public static void showExtent() {
        for (Shipment shipment : extent) {
            System.out.println(shipment);
        }
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "shipDate=" + shipDate +
                ", deliveryDate=" + deliveryDate +
                ", packages=" + packages +
                '}';
    }
}
