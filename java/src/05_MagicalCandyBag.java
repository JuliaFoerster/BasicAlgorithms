import java.util.*;
// Add any extra import statements you may need here

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.Integers;


class Solution {

  // Add any helper functions you may need here
 

  int maxCandies(int[] arr, int k) {

    PriorityQueue<Integer> candyBags = new PriorityQueue<Integer>(Comparator.reverseOrder());
    int candiesEaten=0;
    int candies = 0;
    int i = 0;
    for(int bag:arr){
      candyBags.add(bag);
    }

    while (i<k){
      System.out.println("k = "+k);
      System.out.println("i = "+i);
      
      candies = candyBags.poll();
      // if (candies.isNull){
        candiesEaten = candiesEaten+candies;
      // }
      // else{
      //   return;
      // }
      int newMagicalBag = (int) Math.floor(candies/2);
      candyBags.add(newMagicalBag);

      System.out.println("candies = "+candies);
      System.out.println("candies eaten = "+candiesEaten);
      i=i+1;
    }




    return candiesEaten;
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
    int n_1 = 5, k_1 = 3;
    int[] arr_1 = {2, 1, 7, 4, 2};
    int expected_1 = 14;
    int output_1 = maxCandies(arr_1, k_1);
    check(expected_1, output_1);

    int n_2 = 9, k_2 = 3;
    int[] arr_2 = {19, 78, 76, 72, 48, 8, 24, 74, 29};
    int expected_2 = 228;
    int output_2 = maxCandies(arr_2, k_2);
    check(expected_2, output_2);

    // Add your own test cases here
   
  }
 
  public static void main(String[] args) {
    new Solution().run();
  }
}  
