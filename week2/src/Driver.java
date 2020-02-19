public class Driver {
    public static void main(String[] args) {

       /* Name: Tiger Woods
        Height: 72 inches
        Weight: 190 pounds
        Does travel
        Does not smoke*/

        Model m1 = new Model("Tiger", "Woods", 73,190,true,false);
        //m1.printDetails();
        //m1.displayModelDetails();
        //System.out.println("weight in Kg " + m1.getWeightKg());

        System.out.println();

        Model m2 = new Model("Susan", "Alves", 72,190,false,true);
        m2.setHeight(6,3);
        m2.printDetails();
        m2.displayModelDetails();

    }
}
