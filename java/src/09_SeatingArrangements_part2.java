import java.util.*;
// Add any extra import statements you may need here

import com.google.common.collect.Lists;



class Solution {

    private static int minOverallAwkwardness(int nums[]){
        Arrays.sort(nums);
        // for (int i=0;i<nums.length;i++){
        //     System.out.println(nums[i]);
        // }

        int len = nums.length;

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = len-1; i >= 0; i--){
            if (i % 2 == 0) {
                list.addLast(nums[i]);
            }else{
                list.addFirst(nums[i]);
            }
        }
        System.out.println(list);
        int max = 0;
        int prev = list.get(len-1);
        System.out.println("prev= "+ prev);
        for (int i=0; i < len; i++){
          System.out.println("new iter------------ ");
          System.out.println("prev= "+ prev);
           System.out.println("list.get(i)= "+ list.get(i));

            max = Math.max(Math.abs(list.get(i)-prev), max);
            System.out.println("max= "+ max);
            prev = list.get(i);

        }

        return max;
    }

  // public static int minOverallAwkwardness(int[] arr) {
  //   int awk=0;
  //   int awk_min=1000;

  //   List<Integer> targetList = new ArrayList<>();
  //   for (Integer t : arr){
  //     targetList.add(t);
  //   }
  //   targetList.add(arr[0]);


  //   for (int i=0; i<arr.length; i++){
  //     System.out.println("=======");
  //     System.out.println("i = "+i);
  //     System.out.println("HEIGHT PERSON i = " + arr[i]);
  //     // awk=0;
  //     for (int k=i+1; k<arr.length; k++){

  //       System.out.println("k = "+k);
  //       System.out.println("height person k = " + arr[k]);
  //       awk = awk + Math.abs(arr[i]-arr[k]);
  //       System.out.println("awkwardness = "+ awk);
  //     }
  //     if (awk<awk_min){
  //       awk_min=awk;
  //     }
  //   }

  //   return awk_min;
  // }


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
    int[] arr_1 = {5, 10, 6, 8};
    int expected_1 = 4;
    int output_1 = minOverallAwkwardness(arr_1);
    check(expected_1, output_1);

    // int[] arr_2 = {1, 2, 5, 3, 7};
    // int expected_2 = 4;
    // int output_2 = minOverallAwkwardness(arr_2);
    // check(expected_2, output_2);

    // Add your own test cases here
    // int[] arr_3 = {1, 2, 3};
    // int expected_3 = 1;
    // int output3 = minOverallAwkwardness(arr_3);
    // check(expected_3, output3);
   
  }
 
  public static void main(String[] args) {
    new Solution().run();
  }
}
