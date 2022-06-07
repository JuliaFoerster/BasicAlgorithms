import java.util.*;
// Add any extra import statements you may need here


class Solution {
  // Add any helper functions you may need here
 
 
  boolean isBalanced(String s) {
    char [] input = s.toCharArray(); 
    Stack<Character> stack = new Stack<Character>();

    for (int i=0; i<input.length; i++){
      if (input[i]=='{' || input[i]=='('||input[i]=='['){ // why does "{" not work? 
        stack.push(input[i]);
      }
      else if (input[i] == ']' && stack.peek() == '['){
        stack.pop();
      }
      else if (input[i] == '}' && stack.peek() == '{'){
        stack.pop();
      }
      else if (input[i] == ')' && stack.peek() == '('){
        stack.pop();
      }
      else{
        return false;
      }
        

    }

    return stack.isEmpty();
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
  void printString(String str) {
    System.out.print("[" + str + "]");
  }
 
  public void run() {
    String s_1 = "{[(])}";
    boolean expected_1 = false;
    boolean output_1 = isBalanced(s_1);
    check(expected_1, output_1);

    String s_2 = "{{[[(())]]}}";
    boolean expected_2 = true;
    boolean output_2 = isBalanced(s_2);
    check(expected_2, output_2);

    String s_3 = "[]";
    boolean expected_3 = true;
    boolean output_3 = isBalanced(s_3);
    check(expected_3, output_3);
       
  }
 
  public static void main(String[] args) {
    new Solution().run();
  }
}
