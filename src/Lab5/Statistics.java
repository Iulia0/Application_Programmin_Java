package Lab5;


import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

public class Statistics {

    //return the max value in a list using an Iterator
    static int maximum(List<Integer> list){
        Iterator<Integer> it = list.iterator();
        Integer max = it.next();
        while (it.hasNext()){
           Integer temp = it.next();
           if (temp > max){
               max = temp;
           }
        }
        return max;
    }
    // return the smallest value in a list using an Iterator
    static int minimum(List<Integer> list){
        Iterator<Integer> it = list.iterator();
        Integer min = it.next();
        while (it.hasNext()){
            Integer temp = it.next();
            if (temp < min){
                min = temp;
            }
        }
        return min;
    }
    // return the average in a list using an Iterator
    static double average(List<Integer> list){
        Iterator<Integer> it = list.iterator();
        Integer sum= 0;
        int count = 0;
        while (it.hasNext()){
            Integer temp = it.next();
            sum = sum + temp;
            count++;
        }
        Integer avg = (sum / count);
        return avg;
    }

    //return max value in a list using a for loop
    static int maxi(List<Integer> list){
        int max = list.get(0);
        for (int i = 0; i < list.size(); i++){
            if (list.get(i)> max){
                max = list.get(i);
            }
        }
        return max;
    }
    //return min value in a list using a for loop
    static int mini(List<Integer> list){
        int min = list.get(0);
        for (int i = 0; i < list.size(); i++){
            if (list.get(i)< min){
                min = list.get(i);
            }
        }
        return min;
    }
    //return the average in a list using a for loop
    static double avg(List<Integer> list){
        int sum = 0;
        int count = 0;
        for (int i = 0; i < list.size(); i++){
            sum = sum + list.get(i);
            count++;
        }
        int avg = (sum / count);
        return avg;
    }
    // do the the swap
    public static void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    // in-place technique, it sorts a list of Integers in ascending order without using Collections.sort()
    public static void doSort(List<Integer> list) {
        int minNo;
        for (int i = 0; i < list.size(); i++) {
            //find minimum in the rest of array
            minNo = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(minNo)) {
                    minNo = j;
                }
            }
            //do swap
            swap(list, i, minNo);
        }
    }
    // apply doSort method on the list and print it out
    public static void sortWithout (List list) {
        doSort(list);
        System.out.println(list);
    }
    // sort the list in ascending order using Collections.sort()
    public static void sortWith(List list){
        Collections.sort(list);
        System.out.println(list);
    }

    // extra credit method, sorting a list of Comparable
    public static void showArea(Square[] squares){
        System.out.print("Areas:");
        for (Square sq : squares)
            System.out.print(" " + sq.area());
        System.out.println();
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-3);
        list.add(-8);
        for (int i = 0; i < 100; i = i + 6){
            list.add(i);
        }
        list.add(100);
        list.add(-10);
        System.out.println("##### ex1");
        System.out.println("This is my List: " + list);
        System.out.println("This is the biggest value in the list: " +  maximum(list));
        System.out.println("This is the smallest value in the list: " + minimum(list));
        System.out.println("This is the average: " + average(list));
        System.out.println("_______________________________________________________________");
        System.out.println("Now testing the methods with a for loop instead of an iterator");
        System.out.println("This is the biggest value in the list: " +  maxi(list));
        System.out.println("This is the smallest value in the list: " + mini(list));
        System.out.println("This is the average: " + avg(list));
        System.out.println();
        System.out.println("##### ex3");
        System.out.println("My list:");
        System.out.println(list);
        System.out.println("List after sorting: ");
        sortWithout(list);
        System.out.println("Now using Collecions.sort");
        sortWith(list);
        System.out.println("________________________________________________________");
        System.out.println("EXTRA CREDIT");
        final Square[] sqs = { new Square(5), new Square(13), new Square(4), new Square(6), new Square(9), new Square(6) };
        showArea(sqs);
        Arrays.sort(sqs);
        System.out.println("After");
        showArea(sqs);
    }
}
