package subset;

import util.ObjectPlus4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class State extends ObjectPlus4 {
    private String stateCode;
    private List<City> cityList = new ArrayList<>();

    public static final String roleName = "state";
    public static final String roleConsistsOf = "state consists of";
    public static final String roleManagedBy = "role managed by";

    public State(String stateCode) {
       setStateCode(stateCode);
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        if (stateCode == null) {
            throw new IllegalArgumentException("State code can't be null.");
        }
        this.stateCode = stateCode;
    }

    public void addCity(City city) {
        cityList.add(city);
    }

    public void removeCity(City city) {
        if (!cityList.contains(city)) {
            throw new IllegalArgumentException("This city doesn't belong to this state.");
        }

        cityList.remove(city);
    }

    public List<City> getCityList() {
        return Collections.unmodifiableList(cityList);
    }
}
