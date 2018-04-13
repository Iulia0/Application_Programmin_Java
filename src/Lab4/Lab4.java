package Lab4;

import java.util.*;

class Lab4
{
    public static <T extends Comparable<T>> int smallest(List<T> l)
    {
        if (l.size()==0) return -1;
        else
        {
            Iterator<T> it = l.iterator();
            T smallestSoFar = it.next();
            T temp;
            int smallestPos = 0;
            int i = 1; //used to indicate position in list of next item
            while (it.hasNext()) { // compare next item with smallest so far
                // if it's smaller update smallestSoFar and smallestPos
                temp = it.next();
                int value = temp.compareTo(smallestSoFar);
    //            System.out.println(" this is temp: " + temp +", and this is smallest so far: " + smallestSoFar);
                if (value == -1) {
                    smallestSoFar = temp;
                    smallestPos = l.indexOf(smallestSoFar);
                }
                i++;
            }
            return smallestPos;  // should not do this!
        }
    }

    public static <T extends Comparable<T>> void deleteSmallest(List<T> l)
    { // for exercise 2
        int smallPos = smallest(l);
        if (l.isEmpty()) {

        } else{
            l.remove(smallPos);
        }

    }

    static void replaceNegList(List<Integer> l) {
        List<Integer> list = new ArrayList<>(l);
        System.out.println("This is the list: " + list);
        l.clear();
        Iterator<Integer> it = list.iterator();

        while ( it.hasNext()) {
            Integer nextPositive = Math.abs(it.next());
            l.add(nextPositive);
        }
        System.out.println("This is the list after: " + l);
    }

    public static void main(String[] args)
    {
        System.out.println("You are now testing 'smallest' method");
        Vector<String> vec1 = new Vector<String>();
        vec1.add("aardvark");
        vec1.add("world");
        vec1.add("xxxx");
        vec1.add("Hello");
        vec1.add("a");
        int smallPos = smallest(vec1);
        if (smallPos!=-1)
            System.out.println("smallest entry is " + vec1.elementAt(smallPos) + " at position " + smallPos);


        Vector<Integer> vec2 = new Vector<Integer>();
        vec2.add(new Integer(247));
        vec2.add(new Integer(47));
        vec2.add(new Integer(17));
        vec2.add(new Integer(399));
        vec2.add(65);
        vec2.add((int) 15.0);

        smallPos = smallest(vec2);
        if (smallPos!=-1)
            System.out.println("smallest entry is " + vec2.elementAt(smallPos) + " at position " + smallPos);

        System.out.println();
        System.out.println("You are now testing 'deleteSamllest' method");

        deleteSmallest(vec1);
        smallPos = smallest(vec1);
        System.out.println( "smallest entry is " + vec1.elementAt(smallPos) + " at position " + smallPos);


        deleteSmallest(vec2);
        smallPos = smallest(vec2);
        System.out.println( "smallest entry is " + vec2.elementAt(smallPos) + " at position " + smallPos);

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(655);
        list.add(-10000);
        for(int i = -25; i < 0; i++){
            list.add(i);
        }
        System.out.println();
        System.out.println("You are now testing 'replaceNegList' method");
        replaceNegList(list);
    }


}