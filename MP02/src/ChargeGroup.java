import java.util.ArrayList;
import java.util.List;

public class ChargeGroup {

    private final List<Charge> charges = new ArrayList<>();

    private Shipment shipment;

    public double getChargeGroupValue() {
        double total = 0;

        for (Charge charge : this.charges) {
            total += charge.getChargeValue();
        }

        return total;
    }

    public List<Charge> getCharges() {
        return new ArrayList<>(this.charges);
    }

    public void addCharge(Charge charge) {
        if (charge == null) {
            throw new IllegalArgumentException("Charge cannot be null");
        }

        if (!this.charges.contains(charge)) {
            this.charges.add(charge);
        }
    }

    public void setShipment(Shipment shipment) {
        if (this.shipment != null) {
            return;
        }

        this.shipment = shipment;
    }

    public Shipment getShipment() {
        return this.shipment;
    }

    @Override
    public String toString() {
        return "ChargeGroup{" +
                "chargeGroupValue=" + this.getChargeGroupValue() +
                '}';
    }

}
