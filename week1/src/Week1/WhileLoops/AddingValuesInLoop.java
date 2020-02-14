package Week1.WhileLoops;

import java.util.Scanner;

public class AddingValuesInLoop {
    public static void main(String[] args) {
        /*I will add up the numbers you give me.
                Number: 6
        The total so far is 6
        Number: 9
        The total so far is 15
        Number: -3
        The total so far is 12
        Number: 2
        The total so far is 14
        Number: 0

        The total is 14.*/
        Scanner in = new Scanner(System.in);
        int number = 0;
        int sum = 0;
        boolean finish = false;
        System.out.println("I will add up the numbers you give me.");
        while (!finish){
            System.out.print("Number: ");
            try {
                number = Integer.valueOf(in.nextLine());
                sum = sum + number;
                if(number == 0)
                    finish = true;
                System.out.println(String.format("The total so far is %d ",sum));
            }catch (Exception ex){
                System.out.println("Wrong number try again");
            }

        }

    }
}
