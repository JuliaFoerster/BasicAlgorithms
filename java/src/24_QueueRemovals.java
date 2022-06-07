import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here

import org.apache.commons.lang3.ArrayUtils;


class Solution {

  // Add any helper functions you may need here
  

  public static int[] findPositions(int[] arr, int x) {
    // Stack<Node> stack = new Stack<Node>();  First is LAST out
    
    LinkedList<Integer> queue = new LinkedList<Integer>();
    // ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

    for(int item : arr) {
      queue.add(item);
    }

    int max;
    int maxIndex;

    int []output = new int[x];

    // array = ["A", "B", "C"]
    // array[0]
    // Compute a list of x integers output, the ith of which is the 1-based index in the original array of the element which had been removed in step 2 during the ith iteration.
    //Compute a list of x integers output, the 1st of which is the 1-based index in the original array of the element(4[was index]+1[because one based]) which had been removed in step 2 during the 1st iteration.
    // [0, 0, 0 ,0 ,0 ,0]->[5, 0, 0 ,0 ,0 ,0]

    for (int i=1; i<=x ; i++){
      max = 0;
      maxIndex = 0;
      LinkedList<Integer> temp = new LinkedList<Integer>();
      
      // for(int j = 0; j < x && j<queue.size(); j++) {
      for(int j = 0; j < x; j++) {
        int current_value = queue.poll();
        // max = Math.max(max, current_value);
        System.out.println("Current value = " + current_value);
        if(current_value > max) {
          max = current_value;
          maxIndex = j;
          output[i] = 1 + ArrayUtils.indexOf(arr, max);
        }

        if (current_value>0){
          temp.add(current_value-1);
        }
        else{
          temp.add(current_value);
        }
      }
      // int max = Collections.max(temp);
      System.out.println("max= " + max);
      System.out.println("maxIndex= " + maxIndex);

      System.out.print("temp= ");
      for(int n : temp){
        System.out.print(n + " | ");
      }
      System.out.println("");

      temp.remove(maxIndex); //DarrayQueue does not remove at index but element = maxIndex

      System.out.print("(after max removed) temp= ");
      for(int n : temp){
        System.out.print(n + " | ");
      }
      System.out.println("");


      for(int item : temp) {
        queue.add(item);
      }

      System.out.print("(after adding back to queue) queue= ");
      for(int n : queue){
        System.out.print(n + " | ");
      }
      System.out.println("");

      
      // 1. pop x elements from arr
      // int [] temp = arr.pop()
      // 2. find max of temp
      // max_temp [] int = max(temp)
      // if max_temp.length > 1
      //  remove earliest element from arr
      // else
      //  remove element from arr
      // 3. if temp[i] >0
      //      temp[i]=-1;
      // add temp back to end of the queue
      // arr.add(temp);
    }

    // n = 6
    // arr = [1, 2, 2, 4, 4, 5]
    // x = 5
    // output = [5, 6, 4, 1, 2]

    // [1, 2, 2, 3, 4, 5]
    // temp: [1, 2, 2, 3, 4]
    // max is 4
    // temp: [1, 2, 2, 3]
    // temp: [0, 1, 1, 2]
    // arr = [5, 0, 1, 1, 2]

    //------------example 2-----------

    // n = 6
    // arr = [1, 2, 2, 4, 4, 5]
    // x = 2

    // 1. iteration
    // temp: [1, 2]
    // max is 2
    // temp: [1]
    // temp: [0]
    // arr = [2, 4, 4, 5, 0]

    // 2. iteration
    // temp: [2,4]
    // max is 4
    // temp: [2]
    // temp: [1]
    // arr = [4, 5, 0, 1]

    // ----------example 3---------------
    // arr = {1, 2, 2, 3, 4, 5};
    // x=5

    // 1. iteration
    // temp=[1, 2, 2, 3, 4]
    // max is 4
    // temp: [1,2,2,3]
    // temp: [0 1 1 2]
    // arr = [5 0 1 1 2]

    //2. iteration
    // temp=[4 0 1 1 2]
    // max is 4
    // temp [0 1 1 2]
    // temp [0 0 0 1]
    // arr [0 0 0 1]

    // 3. iteration
    // temp [0 0 0 1]
    // 

    
    // int [] output = {1};

    // int [] output_queue = queue.toArray(new Integer[0]);
    
    int [] output_queue = new int[queue.size()];

    for(int k = 0; k<queue.size(); k++) {
      output_queue[k] = queue.get(k);
    }
    
    

    // return output_queue;

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

    // int n_1 = 6;
    // int x_1 = 1;
    // int[] arr_1 = {1, 2, 2, 3, 4, 5};
    // int[] expected_1 = {2, 2, 3, 4, 5};
    // int[] output_1 = findPositions(arr_1, x_1);
    // check(expected_1, output_1);

    // int n_2 = 6;
    // int x_2 = 2;
    // int[] arr_2 = {1, 2, 2, 3, 4, 5};
    // int[] expected_2 = {4, 5, 0, 1};
    // int[] output_2 = findPositions(arr_2, x_2);
    // check(expected_2, output_2);

    int n_3 = 6;
    int x_3 = 5;
    int[] arr_3 = {1, 2, 2, 3, 4, 5};
    int[] expected_3 = {5, 6, 4, 1, 2 };
    int[] output_3 = findPositions(arr_3, x_3);
    check(expected_3, output_3);
    
    // int n_2 = 13;
    // int x_2 = 4;
    // int[] arr_2 = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
    // int[] expected_2 = {2, 5, 10, 13};
    // int[] output_2 = findPositions(arr_2, x_2);
    // check(expected_2, output_2);
  
    // Add your own test cases here
    
  }
  
  public static void main(String[] args) {
    new Solution().run();
  }
}
