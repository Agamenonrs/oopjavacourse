package Week1.KeyboardInput;

import java.util.Scanner;

public class AgeInFiveYears {
    public static void main(String[] args) {
        /*Hello.  What is your name? Percy_Bysshe_Shelley
        Hi, Percy_Bysshe_Shelley!  How old are you? 34
        Did you know that in five years you will be 39 years old?
        And five years ago you were 29! Imagine that!*/
        Scanner in = new Scanner(System.in);
        String name = "";
        int age = 0;
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
        System.out.println(String.format("Did you know that in five years you will be %d years old?\n" +
                "        And five years ago you were %d! Imagine that!",age + 5 ,age - 5));
    }
}
