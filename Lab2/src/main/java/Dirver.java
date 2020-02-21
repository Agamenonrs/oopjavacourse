public class Dirver {
    public static void main(String[] args) {

        /*
        1- Create an instance(object) of a Canada called canada.
                Canada canada = new Canada();
        2- Call displayAllProvinces() to display all provinces’ info.
                canada.displayAllProvinces();
        3- Call System.out.println(canada.getNumOfProvincesBetween(1, 15));
        Your result should be 6.
        */
        Canada canada = new Canada();
        Canada canada1 = new Canada();
        Canada canada2 = new Canada();
        canada.displayAllProvinces();
        int numOfProvinces = canada.getNumOfProvincesBetween(1,15);
        System.out.println(numOfProvinces);

    }
}
