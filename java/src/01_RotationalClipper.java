import java.util.*;

import org.apache.commons.lang3.ArrayUtils;

class Solution{

  public static String rotationalCipher(String input, int rotationFactor) {

    String [] lowercaseLetters = {"a", "b", "c", "d", "e", "f" , "g" , "h",
                         "i" , "j" , "k" , "l", "m", "n", "o", "p", "q",
                         "r", "s", "t", "u", "v", "w", "x", "y","z"};
    String [] uppercaseLetters = {"A", "B", "C", "D", "E", "F" , "G" , 
                         "H", "I" , "J" , "K" , "L", "M", "N", "O", "P", 
                         "Q", "R", "S", "T", "U", "V", "W", "X", "Y","Z"};
    String [] number = {"0","1","2","3","4","5","6","7","8","9"};
    String [] input_array = input.split("");
    String [] output = input_array;
    int idx;
    boolean isNumber;
    boolean isLowercase;
    boolean isUppercase;

    for(int i=0; i<input.length(); i++){
      isNumber = input_array[i].chars().allMatch(Character::isDigit);
      isUppercase = input_array[i].chars().anyMatch(Character::isUpperCase);
      isLowercase = input_array[i].chars().anyMatch(Character::isLowerCase);

      if (isNumber){
        idx = java.util.Arrays.asList(number).indexOf(input_array[i]);
        output[i] = number[(idx+rotationFactor)%10];
      }
      else if (isLowercase) {
        // creates a list every loop
        // idx = java.util.Arrays.asList(lowercaseLetters).indexOf(input_array[i]); 
        idx = ArrayUtils.indexOf(lowercaseLetters, input_array[i]);
        output[i] = lowercaseLetters[(idx+rotationFactor)%26];
      } else if (isUppercase) {
        // idx = java.util.Arrays.asList(uppercaseLetters).indexOf(input_array[i]);
        idx = ArrayUtils.indexOf(uppercaseLetters, input_array[i]);
        output[i] = uppercaseLetters[(idx+rotationFactor)%26];
      } else {
        output[i]=input_array[i];
      }
    }
    
    return String.join("", output);
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

    String input_1 = "All-convoys-9-be:alert1.";
    int rotationFactor_1 = 4;
    String expected_1 = "Epp-gsrzscw-3-fi:epivx5.";
    String output_1 = rotationalCipher(input_1, rotationFactor_1);
    check(expected_1, output_1);

    String input_2 = "abcdzxyzxy-999.@";
    int rotationFactor_2 = 200;
    String expected_2 = "stuvrpqrpq-999.@";
    String output_2 = rotationalCipher(input_2, rotationFactor_2);
    check(expected_2, output_2);

    String input_3 = "abcdefg12";
    int rotationFactor_3 = 1;
    String expected_3 = "bcdefgh23";
    String output_3 = rotationalCipher(input_3, rotationFactor_3);
    check(expected_3, output_3);

    String input_4 = "abcdefg.@-/12";
    int rotationFactor_4 = 1;
    String expected_4 = "bcdefgh.@-/23";
    String output_4 = rotationalCipher(input_4, rotationFactor_4);
    check(expected_4, output_4);
   
  }
 
  public static void main(String[] args) {
    new Solution().run();
  }
}
