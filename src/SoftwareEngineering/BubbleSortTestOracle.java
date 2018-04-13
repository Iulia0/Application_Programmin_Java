package SoftwareEngineering;

import java.util.Arrays;

/**
 * Iulia Petria
 */
public class BubbleSortTestOracle {
    public static boolean bubble_sort(int[] input,int[] expected ){
/**
 * implement tests (oracles) for each of the test cases to compare the result with the expected
 result and return a Boolean value indicating success of failure

  <insert your code here>
  */
        return Arrays.equals(input, expected);
    }
}
