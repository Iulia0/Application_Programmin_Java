package SoftwareEngineering;

import java.util.Arrays;

/**
 * CE202 Assignment 2
 * Iulia Petria
 */

public class BubbleSort {

    // logic to sort the elements
    public static  int[] bubble_sort(int array[]) {
        int n = array.length;
        int k, temp;
        System.out.println(Arrays.toString(array));
//        screener.printNumbers(array);
        for (int m = n; m > 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (array[i] > array[k]) {
                    temp = array[i];
                    array[i] = array[k];
                    array[k] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
//        screener.printNumbers(array);
        return array;
    }
}
