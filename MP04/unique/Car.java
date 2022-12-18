package unique;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {
    private String vin; // unique
    private String manufacturer;
    private String model;

    private static final List<Car> extent = new ArrayList<>();

    public Car(String vin, String manufacturer, String model) throws UniqueException {
        setVin(vin);
        setManufacturer(manufacturer);
        setModel(model);

        extent.add(this);
    }

    public void setVin(String vin) throws UniqueException {
        for (Car car : extent) {
            if (vin.equals(car.vin)) {
                throw new UniqueException(String.format("VIN: %s already in use.", vin));
            }
        }

        this.vin = vin;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public static List<Car> getExtent() {
        return Collections.unmodifiableList(extent);
    }
}
