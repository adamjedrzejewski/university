package dynamic;

public class Shipment {
    private LoadStatus loadStatus;

    private final String shipmentId;
    private boolean isAtPickLocation = false;
    private boolean isAtDropLocation = false;
    private boolean isEmpty = true;

    public Shipment(String loadId) {
        if (loadId == null) {
            throw new IllegalArgumentException("Shipment id can't be null");
        }

        this.shipmentId = loadId;
        loadStatus = LoadStatus.BOOKED;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public LoadStatus getLoadStatus() {
        return loadStatus;
    }

    public void loadShipment() throws LoadException {
        if (isAtPickLocation && isEmpty) {
            loadStatus = LoadStatus.LOADED;
            isEmpty = false;
        } else {
            throw new LoadException("To load a shipment provider must be at pick up location.");
        }
    }

    public void unLoadShipment() throws LoadException {
        if (isAtDropLocation && !isEmpty) {
            loadStatus = LoadStatus.UNLOADED;
            isEmpty =  true;
        } else {
            throw new LoadException("To unload a shipment provider must be at drop off location.");
        }
    }

    public void goToPickLocation() {
        isAtPickLocation = true;
        isAtDropLocation = false;
    }

    public void goToDropLocation() {
        isAtPickLocation = false;
        isAtDropLocation = true;
    }

}
