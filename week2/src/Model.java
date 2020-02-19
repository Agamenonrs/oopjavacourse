import java.util.Locale;

/**
 * @author Agamenon
 */
public class Model {

    public static final int INCHES_PER_FOOT = 12;
    public static final double POUNDS_PER_KG = 2.2046;
    public static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
    public static final int TALL_INCHES = 67;
    public static final double THIN_POUNDS = 140.0;
    public static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
    public static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
    public static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;


    private String firstName;
    private String lastName;
    private int heightInInches;
    private double weightInPounds;
    private boolean canTravel;
    private boolean smoke;

    /**
     * @param
     * **/
    public Model(){

    }

    /**
     * @param firstName
     * @param lastName
     * @param heightInInches
     * @param weightInPounds
     * @param smoke
     *
    * */
    public Model(String firstName, String lastName, int heightInInches, double weightInPounds, boolean travel, boolean smoke) {
        setFirstName(firstName);
        setLastName(lastName);
        setHeightInInches(heightInInches);
        setWeightInPounds(weightInPounds);
        setCanTravel(travel);
        setSmoke(smoke);
    }

    /**
     * @param firstName
     * @param lastName
     * @param heightInInches
     * @param  weightInPounds
     * **/
    public Model(String firstName, String lastName, int heightInInches, double weightInPounds) {
        setFirstName(firstName);
        setLastName(lastName);
        setHeightInInches(heightInInches);
        setWeightInPounds(weightInPounds);
        setCanTravel(true);
        setSmoke(false);
    }

    public void displayModelDetails(){
        String modelDatails = String.format(Locale.CANADA,
                "Name: %s %s\n%s\nWeight: %.1f pounds\n"
                + "Travels: %s\nSmokes: %s\nHourly rate: $%d",getFirstName(),getLastName(),getHeightInFeetAndInches(), getWeightInPounds(),
                isCanTravel() ? "Yep" : "Nope", isSmoke() ? "yep" : "nope",calculatePayDollarsPerHour());
        System.out.println(modelDatails);

    }


    public int calculatePayDollarsPerHour(){
        int amount = BASE_RATE_DOLLARS_PER_HOUR;
        if ( getHeightInInches() >= TALL_INCHES && getWeightInPounds() <= THIN_POUNDS){
            amount = amount + TALL_THIN_BONUS_DOLLARS_PER_HOUR;
        }
        if (isCanTravel()){
            amount = amount + TRAVEL_BONUS_DOLLARS_PER_HOUR;
        }
        if (isSmoke()){
            amount = amount - SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
        }

        return amount;
    }

    public void printDetails(){
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Height: " + getHeightInInches() + " inches");
        System.out.println("Weight: " + Math.round(getWeightInPounds()) + " pounds");
        if (canTravel == true) {
            System.out.println("Does travel ");
        }else {
            System.out.println("Does not travel ");
        }
        if (smoke == true) {
            System.out.println("Does smoke ");
        }else {
            System.out.println("Does not smoke ");
        }
    }

    /**
     * @return string with height in feet and inches
     */
    public String getHeightInFeetAndInches(){
        long feet =  Math.round( getHeightInInches() / INCHES_PER_FOOT ) ;
        int inch = getHeightInInches() % INCHES_PER_FOOT;
        StringBuilder sb = new StringBuilder(String.format("%d feet ",feet));
        // e.g. "5 feet", or
        // e.g. "5 feet 1 inch", or
        // e.g. "5 feet 6 inches", or
        if (inch > 1)
            sb.append(String.format(" %d inches",inch));
        else if(inch == 1)
            sb.append(String.format(" %d inch",inch));

        return sb.toString();
    }

    /**
     * @return weight in Kg
     */
    public long getWeightKg(){
        return Math.round(getWeightInPounds() / POUNDS_PER_KG);
    }

    /**
     * @param kilograms
     */
    public void setWeight(long kilograms) {
        setWeightInPounds(kilograms * POUNDS_PER_KG);
    }

    /**
     * @param pounds
     */
    public void setWeight(double pounds){
        setWeightInPounds(pounds);
    }

    /**
     * @param feet
     * @param inches
     */
    public void setHeight(int feet, int inches){
        setHeightInInches((feet * INCHES_PER_FOOT) +  inches);
    }

    /**
     * @param inches
     */
    public void setHeight(int inches){
        setHeightInInches(inches);
    }

    private boolean isValidLength(String s, int min, int max ){
        return s !=null && s.length() >= min && s.length() <= max;
    }

    private boolean isValidNumber(int value,int min, int max){
        return value >= min && value <= max;
    }

    /**
     * @return The first name of model
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     */
    public void setFirstName(String firstName) {
        if(isValidLength(firstName,3,20)){
            this.firstName = firstName;
        }
    }

    /**
     * @return The last name of model
     */
    public String getLastName() {
        return lastName;
    }


    /**
     * @param lastName
     */
    public void setLastName(String lastName) {
        if(isValidLength(lastName,3,20)){
            this.lastName = lastName;
        }
    }

    /**
     * @return Height in inches
     */
    public int getHeightInInches() {
        return heightInInches;
    }

    /**
     * @param heightInInches
     */
    public void setHeightInInches(int heightInInches) {
        if (isValidNumber(heightInInches,24,84))
            this.heightInInches = heightInInches;
    }

    /**
     * @return weight in pounds
     */
    public double getWeightInPounds() {
        return weightInPounds;
    }

    /**
     * @param weight
     */
    public void setWeightInPounds(double weight) {
        if( weight >= 80 && weight <= 280)
            this.weightInPounds = weight;
    }

    /**
     * @return  True if model can travel
     */
    public boolean isCanTravel() {
        return canTravel;
    }

    /**
     * @param canTravel
     */
    public void setCanTravel(boolean canTravel) {
        this.canTravel = canTravel;
    }

    /**
     * @return True if model smoke
     */
    public boolean isSmoke() {
        return smoke;
    }

    /**
     * @param smoke
     */
    public void setSmoke(boolean smoke) {
        this.smoke = smoke;
    }
}
