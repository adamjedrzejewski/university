import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Shipment {

    private final List<Charge> chargeList = new ArrayList<>();
    private final List<Package> packageList = new ArrayList<>();
    private LocalDate shipDate;

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

    public List<Package> getPackageList() {
        return new ArrayList<>(packageList);
    }

    public List<Charge> getChargeList() {
        return new ArrayList<>(chargeList);
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "packageList=" + packageList +
                ", shipDate=" + shipDate +
                '}';
    }

    public void removeCharge(Charge charge) {
        if (chargeList.contains(charge)) {
            charge.setShipment(null);
            chargeList.remove(charge);
        }
    }
}
