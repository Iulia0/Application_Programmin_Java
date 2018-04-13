package Lab5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by petri on 11/12/2017.
 */
public class Ex2 {
    //  returns a new list that contains all those items that can be found in both lists
    static List<Integer> sharedItems(List<Integer> listLeft, List<Integer> listRight) {
        List<Integer> newList = new ArrayList<>();
        for (Integer noLeft : listLeft) {
            for (Integer noRight : listRight) {
                if (noLeft == noRight) {
                    newList.add(noRight);
                }
            }
        }
        if (newList.isEmpty()) {
            throw new RuntimeException();
        }
        return newList;
    }


    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(4);
        list1.add(8);
        list1.add(10);
        list1.add(11);
        list1.add(14);

        list2.add(2);
        list2.add(4);
        list2.add(9);
        list2.add(10);
        list2.add(16);
        list2.add(14);

        try {
            System.out.println(sharedItems(list1, list2));
        } catch (RuntimeException e) {
            System.out.println(e.toString());
        }

        list2.remove(1);
        list2.remove(2);
        list2.remove(3);

        try {
            System.out.println(sharedItems(list1, list2));
        } catch (RuntimeException e) {
            System.out.println(e.toString());
        }
    }
}
