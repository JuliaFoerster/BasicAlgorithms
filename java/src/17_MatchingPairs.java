import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here


class Solution {

  private static void swapElement(int i, int k, char [] t_arr, char[] s_arr){ //why private? 
    char temp;
    temp=t_arr[i];
    t_arr[i] = s_arr[k];
    t_arr[k] = temp;
  }
  

  public static int matchingPairs(String s, String t) {
    int count = 0;
    int swap = 0;
    char[] s_arr = s.toCharArray();
    char[] t_arr = t.toCharArray();

    for (int i = 0; i<s.length(); i++){
      if (s_arr[i] == t_arr[i]){
        count=count+1;
      }
      else{
        int k=i;
        while(k<s_arr.length){
            if (s_arr[i] == t_arr[k]){
              if (swap == 0){
                swapElement(i,k,t_arr,s_arr); 
                swap=1;
              }
              count = count + 1;
          }
          k = k+1;
        }
      }
    }
    
    if (swap ==0){
      count=count-2;
    }
    return count;
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
    String s_1 = "abcde";
    String t_1 = "adcbe";
    int expected_1 = 5;
    int output_1 = matchingPairs(s_1, t_1);
    check(expected_1, output_1);

    String s_2 = "abcd";
    String t_2 = "abcd";
    int expected_2 = 2;
    int output_2 = matchingPairs(s_2, t_2);
    check(expected_2, output_2);

    
  }
  public static void main(String[] args) {
    new Solution().run();
  }
}
