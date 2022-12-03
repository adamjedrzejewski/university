package abstractClass;

public abstract class ShipmentService {
    protected HazardousMaterialType hazardousMaterialType = HazardousMaterialType.NOT_HAZARDOUS;

    public HazardousMaterialType getHazardousMaterialType() {
        return hazardousMaterialType;
    }

    public void setHazardousMaterialType(HazardousMaterialType hazardousMaterialType) {
        if (hazardousMaterialType == null) {
            throw new IllegalArgumentException("HazardousMaterialType can't be null");
        }
        this.hazardousMaterialType = hazardousMaterialType;
    }

    public abstract float getBaseFee();
}
