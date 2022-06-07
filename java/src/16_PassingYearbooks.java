import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here
import static org.junit.Assert.*;

class Solution {

  public static boolean isArrayEqual(int [] new_arr, int [] arr){
    try{
      assertArrayEquals(new_arr, arr);
    }
    catch(java.lang.AssertionError e){
      return false;
    }
    return true;
  }

  public static int[] findSignatureCounts(int[] arr) {
    int [] counter = new int [arr.length];
    int [] new_arr = new int [arr.length];
    int [] pointer = new int [arr.length];
    int iter = 0;
    for (int l=0; l< arr.length;l++){
      new_arr[l]=arr[l];
      counter[l]=1;
    }

    // while ((arr[0] != new_arr[0] && arr[1] != new_arr[1]) || iter < 1){
    while (isArrayEqual(new_arr, arr)|| iter < 1){
      iter++;
      for(int k = 0; k<arr.length; k++){
        pointer[k] = new_arr[k]-1;
        new_arr[k] = arr[pointer[k]];
        if (arr[k]!=new_arr[k]){
          counter[k] = counter[k] + 1;
        }
      }
    }
    return counter;
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
    int[] arr_1 = {2, 1};
    int[] expected_1 = {2, 2};
    int[] output_1 = findSignatureCounts(arr_1);
    check(expected_1, output_1);

    // int[] arr_1 = {1,3,4,2};
    // int[] expected_1 = {1,2,2,2};
    // int[] output_1 = findSignatureCounts(arr_1);
    // check(expected_1, output_1);

    int[] arr_2 = {1, 2};
    int[] expected_2 = {1, 1};
    int[] output_2 = findSignatureCounts(arr_2);
    check(expected_2, output_2);
  
    // Add your own test cases here
    
  }
  
  public static void main(String[] args) throws IOException {
    new Solution().run();
  }
}
