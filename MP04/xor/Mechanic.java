package xor;

public class Mechanic {
    private String firstName;
    private String lastName;
    private CarRepairShop carRepairShop = null;
    private AirplaneRepairShop airplaneRepairShop = null;

    public Mechanic(String firstName, String lastName, CarRepairShop carRepairShop, AirplaneRepairShop airplaneRepairShop) {
        if (carRepairShop == null && airplaneRepairShop == null) {
            throw new IllegalArgumentException("Mechanic must be assigned to repair shop.");
        }
        if (carRepairShop != null && airplaneRepairShop != null) {
            throw new IllegalArgumentException("Mechanic must be assigned to repair shop.");
        }

        this.carRepairShop = carRepairShop;
        this.airplaneRepairShop = airplaneRepairShop;
        setFirstName(firstName);
        setLastName(lastName);
    }

    public void setCarRepairShop(CarRepairShop carRepairShop) {
        this.carRepairShop = carRepairShop;
        this.airplaneRepairShop = null;
    }

    public void setAirplaneRepairShop(AirplaneRepairShop airplaneRepairShop) {
        this.carRepairShop = null;
        this.airplaneRepairShop = airplaneRepairShop;
    }

    public boolean isCarRepairShopMechanic() {
        return carRepairShop != null;
    }

    public boolean isAirplaneRepairShopMechanic() {
        return airplaneRepairShop != null;
    }

    public CarRepairShop getCarRepairShop() throws Exception {
        if (!isCarRepairShopMechanic()) {
            throw new Exception("This mechanic is not a car mechanic.");
        }
        return carRepairShop;
    }

    public AirplaneRepairShop getAirplaneRepairShop() throws Exception {
        if (!isAirplaneRepairShopMechanic()) {
            throw new Exception("This mechanic is not an airplane mechanic.");
        }
        return airplaneRepairShop;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("First name can't be null.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("Last name can't be null.");
        }
        this.lastName = lastName;
    }
}
