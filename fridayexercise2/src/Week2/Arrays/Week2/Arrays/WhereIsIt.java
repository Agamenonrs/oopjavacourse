package Week2.Arrays.Week2.Arrays;/*
@author Agamenon
*/

import java.util.Random;
import java.util.Scanner;

public class WhereIsIt {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random r = new Random();
        Scanner in = new Scanner(System.in);
        System.out.print("Array:");
        for (int i = 0; i < array.length; i++){
            array[i] = r.nextInt(49) + 1;
            System.out.print(" " + array[i]);
        }

        System.out.print("\nValue to find ");
        int typedValue = in.nextInt();
        String positions = "";
        for (int i = 0; i < array.length; i++){
            if(array[i] == typedValue){
                if(positions.equals("")){
                    positions = "" + i ;
                }else{
                    positions = i + "," +positions;
                }
             }

        }
        if(!positions.equals("")){
            String[] foundIn = positions.split(",");
            for (String s : foundIn){
                System.out.println(String.format("%d is in slot %s.",typedValue,s));
            }
        }else{
            System.out.println(String.format("%d is not in the array.",typedValue));

        }








    }
}
