import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Shipment {
    private LocalDate shipDate;
    private final List<Package> packages = new ArrayList<>();
    private final HashMap<String, ChargeGroup> chargeGroups = new HashMap<>();

    public Shipment(LocalDate shipDate) {
        setShipDate(shipDate);
    }

    public LocalDate getShipDate() {
        return shipDate;
    }

    public void setShipDate(LocalDate shipDate) {
        if (shipDate == null) {
            throw new IllegalArgumentException("Shipment ship date cannot be null");
        }

        this.shipDate = shipDate;
    }

    public List<Package> getPackages() {
        return new ArrayList<>(packages);
    }

    public void addPackage(Package pkg) {
        if (this.packages.contains(pkg)) {
            return;
        }

        this.packages.add(pkg);
        pkg.setShipment(this);
    }

    public void removePackage(Package pkg) {
        if (!this.packages.contains(pkg)) {
            return;
        }

        this.packages.remove(pkg);
        pkg.removeShipment();
    }

    public void addChargeGroup(String chargeGroupName, ChargeGroup chargeGroup) {
        if (this.chargeGroups.containsKey(chargeGroupName)) {
            return;
        }

        this.chargeGroups.put(chargeGroupName, chargeGroup);
        chargeGroup.setShipment(this);
    }

    public HashMap<String, ChargeGroup> getChargeGroups() {
        return new HashMap<>(this.chargeGroups);
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "shipDate=" + shipDate +
                '}';
    }
}
