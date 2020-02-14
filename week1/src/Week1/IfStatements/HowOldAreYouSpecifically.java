package Week1.IfStatements;

import java.util.Scanner;

public class HowOldAreYouSpecifically {
    public static void main(String[] args) {
        /*Hey, what's your name? (Sorry, I keep forgetting.) Billy_Corgan
        Ok, Billy_Corgan, how old are you? 17
        You can drive but you can't vote, Billy_Corgan.*/

        /*less than 16	"You can't drive."
        16 to 17	"You can drive but not vote."
        18 to 24	"You can vote but not rent a car."
        25 or older	"You can do pretty much anything."*/

        Scanner in = new Scanner(System.in);
        String name = "";
        int age = 0;
        boolean valueOk = false;
        System.out.println("Hey, what's your name? (Sorry, I keep forgetting.)");
        name = in.nextLine();
        while (!valueOk){
            try {
                System.out.println(String.format("Ok, %s, how old are you?", name));
                age = Integer.valueOf(in.nextLine());
                valueOk = true;
            }catch (Exception ex){
                System.out.println("Wrong age try again");
            }
        }
        if (age < 16){
            System.out.println("You can't drive.");
        }else if (age <= 17){
            System.out.println("You can drive but not vote.");
        }else if (age <= 24){
            System.out.println("You can vote but not rent a car.");
        }else if (age > 24){
            System.out.println("You can do pretty much anything.");
        }

    }
}
