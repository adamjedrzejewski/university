public class Truck {
    private String vinNumber;
    private String locatorId;

    private TruckDriver truckDriver;

    public Truck(String vinNumber, String locatorId) {
        this.vinNumber = vinNumber;
        this.locatorId = locatorId;
    }

    public void setTruckDriver(TruckDriver truckDriver) {
        if (this.truckDriver != null) {
            return;
        }

        this.truckDriver = truckDriver;
        this.truckDriver.setTruck(this);
    }

    public void removeTruckDriver() {
        if (this.truckDriver == null) {
            return;
        }

        this.truckDriver.removeLinks();
        this.truckDriver = null;
    }

    public Driver getDriver() {
        return this.truckDriver.getDriver();
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getLocatorId() {
        return locatorId;
    }

    public void setLocatorId(String locatorId) {
        this.locatorId = locatorId;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "vinNumber='" + vinNumber + '\'' +
                ", locatorId='" + locatorId + '\'' +
                '}';
    }
}
