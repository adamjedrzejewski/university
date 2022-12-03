package multiinheritance;

public class Car {
    private String vinNumber;

    public Car(String vinNumber) {
        setVinNumber(vinNumber);
    }

    public String getVinNumber() {
        return vinNumber;
    }

    private void setVinNumber(String vinNumber) {
        if (vinNumber == null) {
            throw new IllegalArgumentException("Vin number can't be null");
        }
        this.vinNumber = vinNumber;
    }
}
