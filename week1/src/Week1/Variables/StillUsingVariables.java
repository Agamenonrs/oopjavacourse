package Week1.Variables;

import java.util.Scanner;

public class StillUsingVariables {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = in.nextLine();
        boolean yearOk = false;
        int year = 0;
        while( ! yearOk){
            System.out.print("Enter your year graduate: ");
            try {
                year = Integer.valueOf(in.nextLine());
                yearOk = true;
            }catch(Exception ex){
                System.out.println("Wrong year try again");
            }

        }
        System.out.println( String.format("My name is %s and I'll graduate in %d.", name, year ));
    }
}
