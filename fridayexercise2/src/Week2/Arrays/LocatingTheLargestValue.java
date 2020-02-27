package Week2.Arrays;
/*
@author Agamenon
*/

import java.util.Random;

public class LocatingTheLargestValue {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        System.out.print("Array: ");
        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(99) + 1;
            System.out.print(array[i] + " ");
        }

        int largestPosition = 0;
        for(int i = 0; i< array.length -1; i++){
            if(array[i+1] > array[largestPosition]){
                largestPosition = i + 1;
            }
        }
        System.out.println("\nThe largest value is: " +array[largestPosition]);
        System.out.println("It is in slot " + largestPosition);
    }
}
