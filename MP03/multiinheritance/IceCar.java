package multiinheritance;

// internal combustion engine car
public class IceCar extends Car {
    protected final double engineDisplacement;
    protected final double power;
    protected final double fuelTankCapacity;

    public IceCar(double engineDisplacement, double power, double fuelTankCapacity, String vinNumber) {
        super(vinNumber);

        if (engineDisplacement <= 0) {
            throw new IllegalArgumentException("Engine displacement must be positive.");
        }
        if (power <= 0) {
            throw new IllegalArgumentException("Power must be positive.");
        }
        if (fuelTankCapacity <= 0) {
            throw new IllegalArgumentException("Fuel tank capacity must be positive.");
        }

        this.engineDisplacement = engineDisplacement;
        this.power = power;
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public double getPower() {
        return power;
    }

    public double getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public double getEngineDisplacement() {
        return engineDisplacement;
    }
}
