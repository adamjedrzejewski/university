package abstractclass;

public class ParcelShipment extends ShipmentService {

    private float length;
    private float width;
    private float height;
    private float weight;

    public ParcelShipment(float length, float width, float height, float weight, HazardousMaterialType hazardousMaterialType) {
        setLength(length);
        setWidth(width);
        setHeight(height);
        setWeight(weight);
        setHazardousMaterialType(hazardousMaterialType);
    }

    @Override
    public void setHazardousMaterialType(HazardousMaterialType hazardousMaterialType) {
        if (hazardousMaterialType == HazardousMaterialType.RADIOACTIVE) {
            throw new IllegalArgumentException("HazardousMaterialType can't be radioactive");
        }
        if (hazardousMaterialType == HazardousMaterialType.EXPLOSIVES) {
            throw new IllegalArgumentException("HazardousMaterialType can't be explosives");
        }
        if (hazardousMaterialType == HazardousMaterialType.CORROSIVE) {
            throw new IllegalArgumentException("HazardousMaterialType can't be corrosive");
        }
        if (hazardousMaterialType == HazardousMaterialType.COMBUSTIBLE_LIQUID) {
            throw new IllegalArgumentException("HazardousMaterialType can't be combustible liquid");
        }
        if (hazardousMaterialType == HazardousMaterialType.SPONTANAEOUSLY_COMBUSTIBLE_AND_DANGEROUS_WHEN_WET) {
            throw new IllegalArgumentException("HazardousMaterialType can't be combustible and dangerous when wet");
        }

        super.setHazardousMaterialType(hazardousMaterialType);
    }

    public void setLength(float length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0.");
        }
        this.length = length;
    }

    public void setWidth(float width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be greater than 0.");
        }
        this.width = width;
    }

    public void setHeight(float height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0.");
        }
        this.height = height;
    }

    public void setWeight(float weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0.");
        }
        this.weight = weight;
    }

    public float getLength() {
        return length;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public float getBaseFee() {
        float materialFee = getHazardousMaterialFee();
        float volumeFee = (height * width * length) / 10.0f;
        float weightFee = weight / 4.0f;

        return materialFee + volumeFee + weightFee;
    }

    private float getHazardousMaterialFee() {
        switch (hazardousMaterialType) {
            case GASES:
                return 10f;
            case FLAMMABLE_LIQUID:
            case FLAMMABLE_SOLID:
                return 20f;
            default:
                return 0;
        }
    }

}