package multiinheritance;

public class ElectricCar extends Car {
    protected final double power;
    protected final double batteryCapacity;

    public ElectricCar(double power, double batteryCapacity, String vinNumber) {
        super(vinNumber);
        if (batteryCapacity <= 0) {
            throw new IllegalArgumentException("Battery capacity must be positive.");
        }
        if (power <= 0) {
            throw new IllegalArgumentException("Power must be positive.");
        }

        this.power = power;
        this.batteryCapacity = batteryCapacity;
    }

    public double getPower() {
        return power;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }
}
