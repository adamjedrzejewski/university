public class Charge {
    private String chargeDescription;
    private double chargeValue;

    private Shipment shipment;

    public Charge(String chargeDescription, double chargeValue) {
        setChargeDescription(chargeDescription);
        setChargeValue(chargeValue);
    }

    public String getChargeDescription() {
        return chargeDescription;
    }

    public void setChargeDescription(String chargeDescription) {
        if (chargeDescription == null || chargeDescription.trim().isEmpty()) {
            throw new IllegalArgumentException("Charge description cannot be null or empty.");
        }

        this.chargeDescription = chargeDescription;
    }

    public double getChargeValue() {
        return chargeValue;
    }

    public void setChargeValue(double chargeValue) {
        if (chargeValue <= 0) {
            throw new IllegalArgumentException("Charge value must be greater than 0.");
        }

        this.chargeValue = chargeValue;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;

    }
}
