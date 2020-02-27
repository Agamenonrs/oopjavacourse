package Week2.ArrayLists;/*
@author Agamenon
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WhereIsIt {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i< 10; i++){
            list.add(random.nextInt(49) + 1);
        }
        System.out.println("ArrayList: " + list);
        System.out.print("Value to find ");
        int typedNumber = Integer.valueOf(in.nextLine().trim());
        boolean found = false;
        for (int i = 0; i < list.size(); i++){
            if(list.get(i) == typedNumber){
                System.out.println(String.format("%d is in slot %d",typedNumber,i));
                found = true;
            }
        }
        if(!found)
            System.out.println(String.format("%d is not in the ArrayList",typedNumber));

    }
}
