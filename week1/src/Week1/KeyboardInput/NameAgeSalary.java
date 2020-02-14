package Week1.KeyboardInput;

import java.util.Scanner;

public class NameAgeSalary {
    public static void main(String[] args) {
        /*Hello.  What is your name?
        Dennis
        Hi, Dennis!  How old are you?
        37
        So you're 37, eh?  That's not old at all!
        How much do you make, Dennis?
        8.50
        8.5!  I hope that's per hour and not per year! LOL!
        */
        Scanner in = new Scanner(System.in);
        String name = "";
        int age = 0;
        double salary = 0.0;
        boolean valueOk = false;
        System.out.println("Hello.  What is your name?");
        name = in.nextLine();
        while (!valueOk){
            try {
                System.out.println(String.format("Hi, %s!  How old are you?", name));
                age = Integer.valueOf(in.nextLine());
                valueOk = true;
            }catch (Exception ex){
                System.out.println("Wrong age try again");
            }
        }
        valueOk = false;
        System.out.println(String.format("So you're %d, eh?  That's not old at all!",age));
        while (!valueOk){
            try {
                System.out.println("How much do you make, Dennis?");
                salary = Double.valueOf(in.nextLine());
                valueOk = true;
            }catch (Exception ex){
                System.out.println("Wrong salary try again");
            }
        }
        System.out.println(String.format("%.1f!  I hope that's per hour and not per year! LOL!",salary));

    }
}
