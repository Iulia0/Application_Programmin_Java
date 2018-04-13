package Lab6;

import java.util.*;
import java.io.*;

public class Map {
    // Map which holds students' marks
    static HashMap<String, Integer> marks = new HashMap<String, Integer>();

    public static class InvalidNumberException extends Exception {
        public InvalidNumberException () {
        }
    }

    // prints the values and keys in a Map
    static void printMap(java.util.Map<String, Integer> myMap) throws InvalidNumberException {
        if (myMap.isEmpty()) {
            throw new RuntimeException();
        } else {
            Iterator<java.util.Map.Entry<String, Integer>> it = myMap.entrySet().iterator();
            while (it.hasNext()) {
                java.util.Map.Entry<String, Integer> pair = it.next();
                if (pair.getValue() < 0){
                    throw new InvalidNumberException();
                }
                System.out.println(pair.getKey() + ": " + pair.getValue());
            }
        }
    }
    // calculate the average value in a Map, throw exception if Map is empty
    static int averageMark(java.util.Map<String, Integer> myMap) throws Exception {
        if (myMap.isEmpty()) {
            throw new RuntimeException();
        }
            Iterator<Integer> it = myMap.values().iterator();
            int sum = 0;
            int count = 0;
            while (it.hasNext()) {
                int next = it.next();
                if (next < 0){
                    throw new InvalidNumberException();
                }
                sum = sum + next;
                count++;
            }

            return (sum / count);
    }

    // find highest value in Map
    static int highestMark(java.util.Map<String, Integer> myMap) throws Exception {
        Iterator<java.util.Map.Entry<String, Integer>> it = myMap.entrySet().iterator();
        java.util.Map.Entry<String, Integer> pair = it.next();
        int highest = 0;
        while (it.hasNext()) {
            pair = it.next();
            if (pair.getValue() > highest){
                highest = pair.getValue();
            }
            if (highest < 0){
                throw new InvalidNumberException();
            }
        }
        if (myMap.isEmpty()) {
            throw new RuntimeException();
        }
        return highest;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        boolean more = true;
        while (more) {
            System.out.print("Name: ");
            String name = null;
            try {
                name = buf.readLine();
            }
            catch (Exception e) {
            }
            System.out.print("Mark: ");
            int mark = 0;
            try {
                mark = Integer.parseInt(buf.readLine().trim());
            } catch (Exception e) {
                System.out.println("invalid input - using 0");
            }
            if(name.isEmpty()){
            }
            else{
                marks.put(name, mark);
            }
            System.out.print("More? ");
            try {
                if (buf.readLine().charAt(0) != 'y')
                    more = false;
            } catch (Exception e) {
                System.out.println("The list is empty");
            }
        }
        try {
            printMap(marks);
            System.out.println("The average mark is: " + averageMark(marks));
            System.out.println("The highest mark is: " + highestMark(marks));
        }
        catch (InvalidNumberException e){
            System.out.println("The marks cannot be negative");
        }
        catch (RuntimeException e) {
            System.out.println("No values in the Map");
        }

    }
}

