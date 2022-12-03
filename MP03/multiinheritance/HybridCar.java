package multiinheritance;

public class HybridCar extends IceCar implements IElectricCar {
    private final double batteryCapacity;
    private final double electricEnginePower;

    public HybridCar(String vinNumber, double engineDisplacement, double iceEnginePower, double fuelTankCapacity, double batteryCapacity, double electricEnginePower) {
        super(engineDisplacement, iceEnginePower, fuelTankCapacity, vinNumber);

        if (batteryCapacity <= 0) {
            throw new IllegalArgumentException("Battery capacity must be positive.");
        }
        if (electricEnginePower <= 0) {
            throw new IllegalArgumentException("Electric engine power must be positive.");
        }

        this.electricEnginePower = electricEnginePower;
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    @Override
    public double getPower() {
        return super.getPower() + electricEnginePower;
    }
}
