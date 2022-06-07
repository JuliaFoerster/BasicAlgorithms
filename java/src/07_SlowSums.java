import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class Solution {

  // first solution using sort array java func
  public static int getTotalTime_sort(int[] arr) {
    int sum_penalty = 0;

    Arrays.sort(arr);
    int count = arr.length-1;
    int penalty = 0;

    while (count > 0){
      penalty = arr[count]+arr[count-1];
      sum_penalty = sum_penalty + penalty;
      arr[count-1] = penalty;
      count = count - 1;
    }

    return sum_penalty;
  }

  // second solution using heaps
  public static int getTotalTime(int[] arr) {

    PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
    for(int item:arr){
      heap.add(item);
    } // can i use lambda function for this?

    int sum_penalty = 0;
    int count = arr.length-1;
    int penalty = 0;

    while (count > 0){
      penalty = heap.poll()+heap.poll();
      sum_penalty = sum_penalty + penalty;
      heap.add(penalty);
      count = count - 1;
    }

    return sum_penalty;
  }



  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom.
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
    int[] arr_1 = {4, 2, 1, 3};
    int expected_1 = 26;
    int output_1 = getTotalTime(arr_1);
    check(expected_1, output_1);

    int[] arr_2 = {2, 3, 9, 8, 4};
    int expected_2 = 88;
    int output_2 = getTotalTime(arr_2);
    check(expected_2, output_2);
 
    // Add your own test cases here
   
  }
  public static void main(String[] args) {
    new Solution().run();
  }
}
