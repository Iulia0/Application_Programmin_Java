package SoftwareEngineering;

import java.util.ArrayList;

/**
 * Iulia Petria
 */
public class BubbleSortTestDriver {
    /**
     * Main function calculating the POFOD on the basis of the return statement
     * results of all test cases
     * POFOD is being printed out
     */
    public static void main(String[] args) {
//insert your code to execute your tests here
//you should implement each test as a separate method below which returns a Boolean value indicating whether the test is successful or not
//to calculate the POFOD you will need to keep a count of the total number of tests and the number of successful tests
        //  <insert your code here>
        ArrayList<Boolean> testsNo = new ArrayList<Boolean>();
        int failed = 0;
        testsNo.add(test1());
        testsNo.add(test2());
        testsNo.add(test3());
        testsNo.add(test4());
        testsNo.add(test5());
        testsNo.add(test6());
        testsNo.add(test7());
        for(Boolean b : testsNo){
            if (b.equals(false)){
                failed++;
            }
        }
        System.out.println("POFOD is : " + failed /testsNo.size()); //output your POFOD

    }

    /**
     * test case implementations
     * return boolean variables which indicate how successful the cases are
     */
    public static boolean test1(){
        int[] arrayInput = {};
        int[] arrayExpected = {};
        BubbleSort test1 = new BubbleSort();
        test1.bubble_sort(arrayInput);
//code to setup the variables and execute the test case 1
//your code will create an instance of the BubbleSort class and execute the bubble_sort method here
//you should then pass the output from the BubbleSort test to the Oracle which will compare the output with the expected output and return a Boolean
//        value indicating success or failure
// <insert your code here>

  return BubbleSortTestOracle.bubble_sort(arrayInput, arrayExpected);
    }

    public static boolean test2(){
        int[] arrayInput = {5};
        int[] arrayExpected = {5};
        BubbleSort test2 = new BubbleSort();
        test2.bubble_sort(arrayInput);
        return BubbleSortTestOracle.bubble_sort(arrayInput, arrayExpected);
    }
    public static boolean test3(){
        int[] arrayInput = {5,9,15,25,45};
        int[] arrayExpected = {5,9,15,25,45};
        BubbleSort test3 = new BubbleSort();
        test3.bubble_sort(arrayInput);
        return BubbleSortTestOracle.bubble_sort(arrayInput, arrayExpected);
    }
    public static boolean test4(){
        int[] arrayInput = {6,2,7,51,56,98,76};
        int[] arrayExpected = {2,6,7,51,56,76,98};
        BubbleSort test4 = new BubbleSort();
        test4.bubble_sort(arrayInput);
        return BubbleSortTestOracle.bubble_sort(arrayInput, arrayExpected);
    }
    public static boolean test5(){
        int[] arrayInput = {6,6,4,9,6,4,9, };
        int[] arrayExpected = {4,4,6,6,6,9,9};
        BubbleSort test5 = new BubbleSort();
        test5.bubble_sort(arrayInput);
        return BubbleSortTestOracle.bubble_sort(arrayInput, arrayExpected);
    }
    public static boolean test6(){
        int[] arrayInput = {-5,-9,-46,-4,-89-7};
        int[] arrayExpected = {-89,-46,-9,-7,-5,-4};
        BubbleSort test6 = new BubbleSort();
        test6.bubble_sort(arrayInput);
        return BubbleSortTestOracle.bubble_sort(arrayInput, arrayExpected);
    }
    public static boolean test7(){
        int[] arrayInput = {15,2,-5,8,-9,-46,0};
        int[] arrayExpected = {-46,-9,-5,0,2,8,15};
        BubbleSort test7 = new BubbleSort();
        test7.bubble_sort(arrayInput);
        return BubbleSortTestOracle.bubble_sort(arrayInput, arrayExpected);
    }
}

