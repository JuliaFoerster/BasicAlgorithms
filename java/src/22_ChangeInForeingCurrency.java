import java.io.*;
import java.util.*;
// Add any extra import statements you may need here

/*
 boolean canGetExactChange(int targetMoney, int[] denominations) {
     if(targetMoney < 0)
       return false;
    if(targetMoney == 0)
      return true;
    for(int i = 0; i < denominations.length;i++){
      if(canGetExactChange(targetMoney - denominations[i], denominations)){
        return true;
      }
    }
    return false;

    {4, 17, 29}
    75

    3
    3 + 3^2
    3 + 3^2 + 3^3
    https://www.wolframalpha.com/input?i=3+%2B+3%5E2+%2B+3%5E3

    3 = 3 = 3(1)
    3 + 3 + 3 + 3 = 12 = (3(1)+3(2))
    3 + 3 + 3 + 3 + 3 + 3 + 3 + 3 + 3 + 3 + 3 + 3 + 3 = 39 = (3(1)+3(2)+3(3) ) = sum of i=1 to n for 3(n recursions)
    {4, 17, 29}

    75-4 =71
    if canGetExactChange(71, denominations) == true {
      return true
    }

    75 - 17 = 58
    if canGetExactChange(58, denominations) == true {
      return true
    }

    75 - 29 =46
    if canGetExactChange(46, denominations) == true {
      return true
    }



    ------------
      58
      if canGetExactChange(58 - 4, denominations) == true {
        return true
      }

      if canGetExactChange(58 - 17, denominations) == true {
        return true
      }

      if canGetExactChange(58 - 29, denominations) == true {
        return true
      }
  ------------------------------
        58 - 29 is 29
        if canGetExactChange(29 - 4, denominations) == true {
          return true
        }

        if canGetExactChange(29 - 17, denominations) == true {
          return true
        }

        if canGetExactChange(29 - 29, denominations) == true {
          return true
        }

        ---------------
        if canGetExactChange(29 - 29, denominations) == true {
          return true
        } ===>  return TRUE
    --------------

    75 - 29
    if canGetExactChange(46, denominations) == true {
      return true
    }
    
  }

*/


class Solution {

  // public static int calculateTargetMoney(int targetMoney){
  //   int digits = (Integer.toString(targetMoney)).length();
  //   int targetMoneyN = (int) (targetMoney%(Math.pow(10, digits-1)));
  //   return targetMoneyN;
  // }

   boolean canGetExactChange(int targetMoney, int[] denominations) {
     if(targetMoney < 0)
       return false;
    if(targetMoney == 0)
      return true;
    for(int i = 0; i < denominations.length;i++){
      if(canGetExactChange(targetMoney - denominations[i], denominations)){
        return true;
      }
    }
    return false;
    
  }
 
  // public static boolean canGetExactChange(int targetMoney, int[] denominations) {
  //   // targetMoney = 8569, 569, 69
  //   for (int i=1; i<denominations.length; i++){
  //     if (targetMoney%denominations[i]==0){ // targetMoney 8569
  //       return true;
  //     }
  //     int nextTargetMoney = calculateTargetMoney(targetMoney); // nextTargetMoney 569
  //     int y = targetMoney - nextTargetMoney; // y 8000

  //     if (y%denominations[i]==0){
  //       return canGetExactChange(nextTargetMoney, denominations);
  //     } 
  //     else{
  //       return false;
  //     }
  //   }
  //   return false;
  // }

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
  void printString(String str) {
    System.out.print("[\"" + str + "\"]");
  }
 
  public void run() {
    int target_1 = 94;
    int arr_1[] = {5, 10, 25, 100, 200};
    boolean expected_1 = false;
    boolean output_1 = canGetExactChange(target_1, arr_1);
    check(expected_1, output_1);

    int target_2 = 75;
    int arr_2[] = {4, 17, 29};
    boolean expected_2 = true;
    boolean output_2 = canGetExactChange(target_2, arr_2);
    check(expected_2, output_2);
   
    // Add your own test cases here
   
  }
 
  public static void main(String[] args) {
    new Solution().run();
  }
}
