import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class Solution {

  public static String concat (String a, String b, String c){
    return a + b + c;
  }


  public static String findEncryptedWord(String s) {
    int mid = 99999;
    if (s.length()==1){
      return s;
    }

    if ((s.length())%2==0){
        System.out.println("even");
        mid = (s.length()/2)-1;
    }
    if ((s.length())%2==1){
        System.out.println("odd");
        mid = (s.length()/2)-1;
    }
    System.out.println("String = " + s);
    System.out.println("mid = " + mid);
    String start = s.substring(0,mid);
    String middle = s.substring(mid,mid+1);
    String end = s.substring(mid+1, s.length());
    System.out.println("Start = " + start);
    System.out.println("Middle = " + middle);
    System.out.println("end = " + end);

    return concat(findEncryptedWord(start),findEncryptedWord(middle), findEncryptedWord(end));
  }

  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom.
  int test_case_number = 1;
  void check(String expected, String output) {
    boolean result = (expected.equals(output));
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printString(expected);
      System.out.print(" Your output: ");
      printString(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printString(String str) {
    System.out.print("[\"" + str + "\"]");
  }
 
  public void run() {
    // String s_1 = "abc";
    // String expected_1 = "bac";
    // String output_1 = findEncryptedWord(s_1);
    // check(expected_1, output_1);

    String s_2 = "abcd";
    String expected_2 = "bacd";
    String output_2 = findEncryptedWord(s_2);
    check(expected_2, output_2);

    // Add your own test cases here
   
  }
 
  public static void main(String[] args) {
    new Solution().run();
  }
}
