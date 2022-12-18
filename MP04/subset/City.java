package subset;

import util.ObjectPlus4;

public class City extends ObjectPlus4 {
    private String cityName;
    private int population;

    public static String roleName = "city";
    public static String roleBelongsTo = "city belongs to";
    public static String roleManages = "city manages";

    public City(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        if (population < 0) {
            throw new IllegalArgumentException("Population can't be negative");
        }
        this.population = population;
    }
}
