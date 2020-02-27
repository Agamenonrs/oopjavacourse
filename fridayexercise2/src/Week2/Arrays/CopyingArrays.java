package Week2.Arrays;
/*
@author Agamenon
*/

import java.util.Random;

public class CopyingArrays {
    public static void main(String[] args) {
        int[] array1 = new int[10];
        int[] array2;
        Random random = new Random();

        for (int i = 0 ; i< array1.length; i++)
            array1[i] = random.nextInt(99)+1;

        array2 = array1.clone();
        array1[array1.length-1] = -7;

        System.out.print("Array 1:");
        for (int i = 0; i < array1.length; i++){
            System.out.print(" " +array1[i]);
        }
        System.out.print("\n");
        System.out.print("Array 2:");
        for (int i = 0; i < array2.length; i++){
            System.out.print(" " +array2[i]);
        }


    }
}
