import java.time.LocalDate;
import java.util.Calendar;

public class TruckDriver {

    private LocalDate from, to;

    private Truck truck;
    private Driver driver;

    public TruckDriver(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        if (this.truck != null) {
            return;
        }

        this.truck = truck;
        this.truck.setTruckDriver(this);
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        if (this.driver != null) {
            return;
        }

        this.driver = driver;
        this.driver.setTruckDriver(this);
    }

    public void removeLinks() {
        removeDriver();
        removeTruck();
    }

    private void removeTruck() {
        if (this.truck == null) {
            return;
        }

        this.truck.removeTruckDriver();
        this.truck = null;
    }

    private void removeDriver() {
        if (this.driver == null) {
            return;
        }

        this.driver.removeTruckDriver();
        this.driver = null;
    }
}
