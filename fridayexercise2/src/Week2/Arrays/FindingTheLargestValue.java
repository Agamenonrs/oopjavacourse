package Week2.Arrays;
/*
@author Agamenon
*/

import java.util.Random;

public class FindingTheLargestValue {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i< array.length; i++){
            array[i] = random.nextInt(99) + 1;
        }

        System.out.print("Array: ");
        int largest = array[0];
        for(int value : array){
            System.out.print(value + " ");
            if(value > largest)
                largest = value;
        }
        System.out.println("\nThe largest value is: " +largest);
    }
}
