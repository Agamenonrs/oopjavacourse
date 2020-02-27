package Week2.ArrayLists;/*
@author Agamenon
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists2 {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i< 10; i++)
            lista.add(random.nextInt(99) + 1);
        System.out.println("ArrayList: " +lista);
    }

}
