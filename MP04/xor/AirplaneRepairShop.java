package xor;

public class AirplaneRepairShop {

    private String airPortCode;
    private int hangarNumber;

    public AirplaneRepairShop(String airPortCode, int hangarNumber) {
        setAirPortCode(airPortCode);
        setHangarNumber(hangarNumber);
    }

    public String getAirPortCode() {
        return airPortCode;
    }

    public void setAirPortCode(String airPortCode) {
        if (airPortCode == null) {
            throw new IllegalArgumentException("Airport code cannot be null.");
        }
        this.airPortCode = airPortCode;
    }

    public int getHangarNumber() {
        return hangarNumber;
    }

    public void setHangarNumber(int hangarNumber) {
        this.hangarNumber = hangarNumber;
    }
}
