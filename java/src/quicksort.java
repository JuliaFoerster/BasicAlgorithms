/*
 * Click `Run` to execute the snippet below!
 */

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
  public static int[] quickSort(int[] input) {
    int pivot = input.length/2;
    ArrayList<Integer> smaller_elements = new ArrayList<Integer>();
    ArrayList<Integer> larger_elements = new ArrayList<Integer>();
    ArrayList<Integer> mid = new ArrayList<Integer>();

    if (input.length <2){ //input.length == 1 or input == {} for empty (check in pencil code)
      return input;
    }

    for (int i =0 ; i<input.length; i++){
      if (input [i] > input[pivot] ){
        larger_elements.add(input[i]);
      }
      if (input [i] < input[pivot] ){
        smaller_elements.add(input[i]);
      }
      if (input [i] == input[pivot] ){
        mid.add(input[pivot]);
      }
    }

  

    int[] smaller_elements_array = smaller_elements.stream().mapToInt(i->i).toArray();
    int[] larger_elements_array = larger_elements.stream().mapToInt(i->i).toArray();
    int[] mid_array = mid.stream().mapToInt(i->i).toArray();

    return concat(quickSort(smaller_elements_array), mid_array, quickSort(larger_elements_array));
  }

  public static int [] concat(int [] start, int [] mid, int [] end){

    int [] left = ArrayUtils.addAll(start, mid);
    int [] all = ArrayUtils.addAll(left, end);

    return all;
  }

  public static void main(String[] args) {
    int[] input = {22,4,33,4,1};
    int[] expectedOutput = {1,4,4,22,33};

    int [] result = quickSort(input);

    org.junit.Assert.assertArrayEquals(expectedOutput, result);
    System.out.println("OK");
  }
}
