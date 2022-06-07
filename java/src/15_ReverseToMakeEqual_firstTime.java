import java.io.*;
import java.util.*;
// Add any extra import statements you may need here

import org.apache.commons.lang3.ArrayUtils;


class Solution {


  public static boolean areTheyEqual(int[] array_a, int[] array_b) {
    boolean elementsArrayAInArrayB = true;
    boolean elementsArrayBInArrayA = true;

    if (array_a.length == array_b.length){å
      for (int i =0; i<array_b.length; i++){
        elementsArrayAInArrayB = ArrayUtils.contains(array_a, array_b[i]);
        elementsArrayBInArrayA = ArrayUtils.contains(array_b, array_a[i]);
        if (elementsArrayAInArrayB==false || elementsArrayBInArrayA==false){
          return false;
        }
      }
    }
    return true;
  }

  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom.
  int test_case_number = 1;
  void check(boolean expected, boolean output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      System.out.print(expected);
      System.out.print(" Your output: ");
      System.out.print(output);
      System.out.println();
    }
    test_case_number++;
  }
 
  public void run() {
    int[] array_a_1 = {1, 2, 3, 4};
    int[] array_b_1 = {1, 4, 3, 2};
    boolean expected_1 = true;
    boolean output_1 = areTheyEqual(array_a_1, array_b_1);
    check(expected_1, output_1);

    int[] array_a_2 = {1, 2, 3, 4};
    int[] array_b_2 = {1, 4, 3, 3};
    boolean expected_2 = false;
    boolean output_2 = areTheyEqual(array_a_2, array_b_2);
    check(expected_2, output_2);
    
    int[] array_a_3 = {1, 2, 3, 5};
    int[] array_b_3 = {1, 4, 3, 3};
    boolean expected_3 = false;
    boolean output_3 = areTheyEqual(array_a_3, array_b_3);
    check(expected_3, output_3);
   
  }
 
  public static void main(String[] args) {
    new Solution().run();
  }
}
