/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    public static List<Integer> mergeSort(List<Integer> input) {
      if (input.size()==1 || input.isEmpty()){
        return input;
      }
      int splitIndex = (input.size()/2);
      System.out.println(input);
      System.out.println(splitIndex);
      System.out.println(input.size());

      List<Integer> left = input.subList(0, splitIndex);
      List<Integer> right = input.subList(splitIndex, input.size());

      return merge(mergeSort(left), mergeSort(right));
    }

    public static  List<Integer> merge(List<Integer> left, List<Integer> right) {
      List<Integer> output = new ArrayList<Integer>();

      int l = 0;
      int r = 0;


      while(l < left.size() && r <right.size()){
        System.out.println("l " + l);
        System.out.println("r " +r );
        System.out.println("right.get(r) " + right.get(r));
        System.out.println("left.get(l) " + left.get(l));

        int valueLeft = left.get(l);
        int valueRight = right.get(r);

        if (valueLeft<valueRight){
          output.add(valueLeft);
          l++;
        }
        if (valueLeft>valueRight){
          output.add(valueRight);
          r++;
        }
        if (valueLeft == valueRight){
          output.add(valueLeft);
          output.add(valueRight);
          r++;
          l++;
        }
      }
      if (r < right.size()){
          output.addAll(right.subList(r, right.size()));
      }
      if (l < left.size()){
          output.addAll(left.subList(l, left.size()));
      }

      
      return output;
    }

    public static void main(String[] args) {
    int[] arrInput = {22,4,33,4,1};
    int[] arrExpectedOutput = {1,4,4,22,33};
       
    ArrayList<Integer> input = (ArrayList<Integer>) Arrays.stream(arrInput).boxed().collect(Collectors.toList());

    ArrayList<Integer> expectedOutput = (ArrayList<Integer>) Arrays.stream(arrExpectedOutput).boxed().collect(Collectors.toList());

    List<Integer> result = mergeSort(input);

    org.junit.Assert.assertEquals(expectedOutput, result);
    System.out.println("OK");
  }
}
