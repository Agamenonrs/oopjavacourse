import java.util.Arrays;
import java.util.List;

public class Province {


    private static final long DEFAULT_POPULATION = 4_648_055;
    private static final String DEFAULT_PROVINCE = "British Columbia";
    private static final String DEFAULT_CAPITAL = "Victoria";
    private static final long MIN_POPULATION = 30_000;
    private static final long MAX_POPULATION = 15_000_000;

    private String name;
    private String capital;
    private long population;
    static List<String> provinces;
    static List<String> capitals;

    static {
        String[] p = new String[] {"Ontario","Quebec","Nova Scotia", "New Brunsweck", "Manitoba",
                "British Columbia", "Prince Edward Island", "Saskatchewan",
                "Alberta", "Newfoundland and Labrador"};
        String[] c = new String[]{"Toronto","Quebec City","Halifax","Fredericton","Winnipeg","Victoria",
                "Charlottetown", "Regina", "Edmonton", "St. John's" };

        provinces = Arrays.asList(p);
        capitals = Arrays.asList(c);
    }

    public Province(String name, String capital, long population) {
        if (isValidPopulation(population) && isValidProvince(name)
                && isValidCapitalCity(capital)) {

            this.name = name;
            this.capital = capital;
            this.population = population;
        } else {
            this.population = DEFAULT_POPULATION;
            this.name = DEFAULT_PROVINCE;
            this.capital = DEFAULT_CAPITAL;
        }

    }

    public String getDetails(){
        //Must return
        //The capital of British Columbia (population. 4648055) is Victoria.
        return String.format("The capital of %s (population. %d) is %s.",name,population,capital);
    }

    private boolean isValidCapitalCity(String capital) {
        return capitals.contains(capital);
    }

    private boolean isValidProvince(String name) {
        return provinces.contains(name);
    }

    private boolean isValidPopulation(long population) {
        if(population < MIN_POPULATION || population > MAX_POPULATION)
            return false;

        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
}
