public class Package {
    private int weight;

    private Shipment shipment;

    public Package(int weight) {
        setWeight(weight);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Package weight must be positive.");
        }
        this.weight = weight;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {

    }

    @Override
    public String toString() {
        return "Package{" +
                "weight=" + weight +
                '}';
    }
}
