package Week2.Arrays;/*
@author Agamenon
*/

import javax.swing.*;
import java.util.Random;
import java.util.stream.IntStream;

public class BasicArrays2 {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();

        for (int i = 0 ; i< array.length; i++)
            array[i] = random.nextInt(99)+1;
        for (int i = 0; i < array.length; i++)
            System.out.println(String.format("Slot %d contains a %d", i,array[i]));

    }

}
