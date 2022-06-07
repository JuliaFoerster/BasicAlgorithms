/*
 * Click `Run` to execute the snippet below!
 */

import static org.junit.Assert.assertArrayEquals;

import java.io.*;
import java.util.*;

import org.apache.commons.lang3.ArrayUtils;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {

  public static int[] findMinArray(int[] arr, int k){
    int[] arr_copy = Arrays.copyOf(arr, arr.length);
    Arrays.sort(arr_copy);

    for(int i=0; i<=arr.length; i++){
      int current = arr_copy[i];
      int index_of_current = ArrayUtils.indexOf(arr, current);
      if(index_of_current<=k){
        System.out.println("hi there");
        for(int j=k; j>=1; j--){
          int temp=arr[j-1];
          arr[j-1]=arr[j];
          arr[j]=temp;
        }
        return arr;
      }
    }
    return arr;// return itself as it as the smallesrt
  }


  public static void main(String[] args) {
    int[] input = {8,2,11,1,3};
    int k = 3;

    int [] expected = {1, 8, 2, 11, 3};
    int [] notExpected = {1, 8, 2, 11, 334};
    int[] actual = findMinArray(input, k);


    assertArrayEquals(expected, actual);


    try {
      assertArrayEquals(notExpected, actual);
    } catch(java.lang.AssertionError error) {
      System.out.println(error.toString());
    }

    for(int n : actual){
      System.out.println(n);
    }
  }
}
