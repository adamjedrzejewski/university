public class Charge {
    private String chargeDescription;
    private double chargeValue;

    private ChargeGroup chargeGroup;

    public Charge(ChargeGroup chargeGroup, String chargeDescription, double chargeValue) {
        setChargeValue(chargeValue);
        setChargeDescription(chargeDescription);
        setChargeGroup(chargeGroup);
    }

    private void setChargeGroup(ChargeGroup chargeGroup) {
        if (this.chargeGroup != null) {
            return;
        }

        this.chargeGroup = chargeGroup;
        this.chargeGroup.addCharge(this);
    }

    public String getChargeDescription() {
        return chargeDescription;
    }

    public void setChargeDescription(String chargeDescription) {
        if (chargeDescription == null || chargeDescription.trim().isEmpty()) {
            throw new IllegalArgumentException("Charge description cannot be null, blank or empty.");
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

    public ChargeGroup getChargeGroup() {
        return chargeGroup;
    }
}
