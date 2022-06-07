import java.io.*;
import java.util.*;
// Add any extra import statements you may need here

import org.postgresql.jdbc2.ArrayAssistant;


/*
Hashtable
key: value
[1 2 3 4 3]
1: [2 3 4 3]
2: [1 3 4 3]
3: [1 2 4 3]
4: [1 2 3 3]
3: [1 2 3 4]

Solution  (using array) Brute Force
for i=0; i<length
  for j=i ;j<length
    if (arr[i]+arr[j]==k)
      count = count+1


return count

*/

class Solution {

  public static int numberOfWays_usingArrays(int[] arr, int sum) {
    int number_matches = 0 ;
  
    for (int i=0; i<arr.length; i++){
      for (int k=i+1; k<arr.length; k++){
        if (arr[i]+arr[k]==sum){
          number_matches++;
        }
      }
    }
    return number_matches;
  }

  public static int numberOfWays(int[] arr, int target) {
    HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
    for (int i = 0; i<arr.length; i++){
      Integer countLetter = counter.get(arr[i]);
      if (countLetter==null){
        countLetter = 1;
      }
      else{
        countLetter++;
      }
      counter.put(arr[i],countLetter);
    }

    int number_matches =0;
    int diff;
    for(int i : counter.keySet()){
      diff = target-counter.get(i);
      if(counter.get(diff)!=null){
        int temp_pair1=counter.get(diff);
        int temp_pair2=counter.get(i);
        int max = Math.max(temp_pair1, temp_pair2);
        counter.put(diff, temp_pair1-max);
        counter.put(i, temp_pair2-max);
        number_matches=number_matches+max;
      }
    }

    return number_matches;
  }


  int test_case_number = 1;

  void check(int expected, int output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printInteger(expected);
      System.out.print(" Your output: ");
      printInteger(output);
      System.out.println();
    }
    test_case_number++;
  }

  void printInteger(int n) {
    System.out.print("[" + n + "]");
  }

  public void run() {
    int k_1 = 6;
    int[] arr_1 = {7, 1, 2, 3, 4, 3};
    int expected_1 = 2;
    int output_1 = numberOfWays(arr_1, k_1);
    check(expected_1, output_1);

    // int k_2 = 6;
    int[] arr_2 = {1, 5, 3, 3, 3};
    int expected_2 = 4;
    int output_2 = numberOfWays(arr_2, 6);
    check(expected_2, output_2);
   
  }
  public static void main(String[] args) {
    new Solution().run();
  }
}
