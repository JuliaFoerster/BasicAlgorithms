import java.io.*;
import java.util.*;

class Solution {

  public int[] countSubarrays(int[] arr) {
    
    int[] output = new int[arr.length];
    int count_right =0;
    int count_left=0;
    int k;
    int [] count_left_array =  new int[arr.length];
    int [] count_right_array =  new int[arr.length];


    for (int i= 0; i<arr.length; i++){
      count_right=0;
      System.out.println("----------------");
      k = i;
      while (arr[i] >= arr[k]){
        System.out.println("i = " +i);
        System.out.println("k = " +k);
        System.out.println("arr[i] = " +arr[i]);
        System.out.println("arr[k] = " +arr[k]);
        if (arr[i] >= arr[k]){
          count_right = count_right+1;
          System.out.println("count_right = " +count_right);
        }
        k=k+1;
        if (k==arr.length){
          break;
        }
      }
    }

    System.out.println("WALK LEFT");
    for (int i= arr.length-1; i>-1; i--){
      count_left=0;
      System.out.println("----------------");
      k = i;
      while (arr[i] >= arr[k]){
        System.out.println("i = " +i);
        System.out.println("k = " +k);
        System.out.println("arr[i] = " +arr[i]);
        System.out.println("arr[k] = " +arr[k]);
        if (arr[i] >= arr[k]){
          count_left = count_left+1;
          System.out.println("count_left = " +count_left);
        }
        k=k-1;
        if (k<0){
          break;
        }
      }
      count_left_array[i] = count_left;
      count_right_array[i] = count_right;

      output [i]= count_left+count_right;
      //Summed up wrongly (duplicates when comparing i to i -> counts up to count_left+count_right=1+1=2 as we get a match for right and left side walks, but its the same ((i and i)is the same (as i and i). So it should be 1, not 2.
    }
    System.out.println("RESULTS!!!!!!!!!!!");
    for (int i = 0; i<count_left_array.length; i++){
      System.out.println("count_left_array = " + count_left_array[i]);
      System.out.println("count_right_array = " + count_right_array[i]);
    }

    return output;
  }



  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom.
  int test_case_number = 1;
  void check(int[] expected, int[] output) {
    int expected_size = expected.length;
    int output_size = output.length;
    boolean result = true;
    if (expected_size != output_size) {
      result = false;
    }
    for (int i = 0; i < Math.min(expected_size, output_size); i++) {
      result &= (output[i] == expected[i]);
    }
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printIntegerArray(expected);
      System.out.print(" Your output: ");
      printIntegerArray(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printIntegerArray(int[] arr) {
    int len = arr.length;
    System.out.print("[");
    for(int i = 0; i < len; i++) {
      if (i != 0) {
        System.out.print(", ");
      }
      System.out.print(arr[i]);
    }
    System.out.print("]");
  }
  public void run() {
    int[] test_1 = {3, 4, 1, 6, 2};
    int[] expected_1 = {1, 3, 1, 5, 1};
    int[] output_1 = countSubarrays(test_1);
    check(expected_1, output_1);

    // int[] test_2 = {2, 4, 7, 1, 5, 3};
    // int[] expected_2 = {1, 2, 6, 1, 3, 1};
    // int[] output_2 = countSubarrays(test_2);
    // check(expected_2, output_2);

    // Add your own test cases here

  }
  public static void main(String[] args) {
    new Solution().run();
  }
}
