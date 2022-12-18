package custom;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Load {
    private String loadId;
    private LocalDate shipDate; // custom
    private Dimensions dimensions;

    public Load(String loadId, LocalDate shipDate, Dimensions dimensions) {
        setLoadId(loadId);
        setShipDate(shipDate);
        setDimensions(dimensions);
    }

    public void setShipDate(LocalDate shipDate) {
        DayOfWeek day = shipDate.getDayOfWeek();
        if (day.equals(DayOfWeek.SUNDAY) || day.equals(DayOfWeek.SATURDAY)) {
            throw new IllegalArgumentException("Shipping during the weekend is not possible.");
        }

        this.shipDate = shipDate;
    }

    public String getLoadId() {
        return loadId;
    }

    public void setLoadId(String loadId) {
        this.loadId = loadId;
    }

    public LocalDate getShipDate() {
        return this.shipDate;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

}
