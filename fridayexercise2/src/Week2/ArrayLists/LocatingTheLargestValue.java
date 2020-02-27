package Week2.ArrayLists;/*
@author Agamenon
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LocatingTheLargestValue {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++){
            list.add(random.nextInt(99) +1);
        }
        System.out.println("ArrayList: " + list);
        Integer largestInIndex = 0;
        for (int i = 0; i < list.size() - 1; i++){
            if(list.get(i+1) > list.get(largestInIndex))
                largestInIndex = i+1;
        }
        System.out.println(String.format("The largest value is %d, which is in slot %d",list.get(largestInIndex),largestInIndex));
    }
}
