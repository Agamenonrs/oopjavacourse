package Week1.ForLoops;

import java.util.Scanner;

public class CountingMachine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        boolean valueOk = false;

        while (!valueOk){
            try {
                System.out.print("Count to: ");
                count = Integer.valueOf(in.nextLine());
                valueOk = true;
            }catch (Exception ex){
                System.out.println("Wrong number try again");
            }
        }
        for (int i = 0; i<= count;i++)
            System.out.print(i + " ");

    }
}
