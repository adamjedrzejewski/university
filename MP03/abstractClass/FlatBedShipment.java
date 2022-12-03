package abstractclass;

public class FlatBedShipment extends ShipmentService {

    private float length;
    private float weight;

    public FlatBedShipment(float length, float weight, HazardousMaterialType hazardousMaterialType) {
        setLength(length);
        setWeight(weight);
        this.setHazardousMaterialType(hazardousMaterialType);
    }

    public void setLength(float length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0.");
        }
        this.length = length;
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

    public float getWeight() {
        return weight;
    }

    @Override
    public float getBaseFee() {
        float materialFee = getHazardousMaterialFee();
        float weightFee;
        if (weight > 50) {
            weightFee = 10;
        } else {
            weightFee = 5;
        }

        if (length < 5) {
            return materialFee + length + 3 * weightFee;
        }
        if (length < 10) {
            return materialFee + 2 * length + 2 * weightFee;
        }

       return materialFee + 3 * length +  weightFee;
    }

    private float getHazardousMaterialFee() {
        switch (hazardousMaterialType) {
            case RADIOACTIVE:
                return 5000;

            case EXPLOSIVES:
                return 2000;

            case CORROSIVE:
                return 1000;

            case COMBUSTIBLE_LIQUID:
            case SPONTANAEOUSLY_COMBUSTIBLE_AND_DANGEROUS_WHEN_WET:
                return 800;

            case FLAMMABLE_SOLID:
            case FLAMMABLE_LIQUID:
                return 700;

            case OXIDIZER:
                return 600;

            case ORGANIC_PEROXIDE:
            case GASES:
            case POISON_AND_POISON_INHALATION_HAZARD:
                return 300;

            case NOT_HAZARDOUS:
            default:
                return 50;
        }
    }
}