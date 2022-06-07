import java.util.*;
import java.util.stream.Collectors;

class Solution {


  public static int [] accumulate(int [] revenues){
    int [] acc_revenue = new int[revenues.length];
    int acc = 0;
    System.out.println("REVENUE ACC");
    
    for (int i=0; i<revenues.length; i++){
      acc=acc+revenues[i];
      acc_revenue[i]=acc;
      System.out.println(acc_revenue[i]);
    }

    return acc_revenue;
  }

  public static int binarySearch(ArrayList<Integer> list, int searchValue){
    int high = list.size()-1;
    int low = 0;
    int mid;

    while (low<=high){

      mid =  (high+low)/2;

      if (list.get(mid)<searchValue){
        low = mid + 1;
      }

      if (list.get(mid)>searchValue){
        high = mid - 1;
      }

      if (list.get(mid)==searchValue){
        return mid;
      }
    }

    return -1;
  }

  public static int[] getMilestoneDaysBinarySearch(int[] revenues, int[] milestones) {
    int[] targetHit = new int [milestones.length];
    int targetReached =0;

    int [] acc_revenue = accumulate(revenues);

    ArrayList<Integer> milestoneList = (ArrayList<Integer>) Arrays.stream(milestones).boxed().collect(Collectors.toList());

    ArrayList<Integer> acc_revenueList = (ArrayList<Integer>) Arrays.stream(acc_revenue).boxed().collect(Collectors.toList());

    while(milestoneList!=null){
      targetReached =  binarySearch(acc_revenueList, milestoneList.get(0));
      while (targetReached!=-1){
        milestoneList.remove(targetReached-1);
      }
    }

    return targetHit;
  }

  // Brute Force O(n2)
  public static int[] getMilestoneDaysBruteForce(int[] revenues, int[] milestones) {
    int [] output = new int[milestones.length];
    int [] acc_revenue = accumulate(revenues);

    for (int k = 0; k<milestones.length; k++){
      for (int i = 0; i<revenues.length; i++){
        if ((acc_revenue[i] - milestones[k])>=0){
          output[k]=i+1;
          break;
        }
      }
    }
    return output;
  }

  //
  public static int[] getMilestoneDays_CURRENT(int[] revenues, int[] milestones) {
    int [] output = new int[milestones.length];
    int [] acc_revenue = accumulate(revenues);

    for (int k = 0; k<milestones.length; k++){
      for (int i = 0; i<revenues.length; i++){
        if ((acc_revenue[i] - milestones[k])>=0){
          output[k]=i+1;
          break;
        }
      }
    }
    return output;
  }


  public static int[] getMilestoneDays(int[] revenues, int[] milestones) {
    int [] output = new int[milestones.length];

    // int revenues_1[] = {100, 200, 300, 400, 500};
    // int milestones_1[] = {300, 800, 1000, 1400};
    // int expected_1[] = {2, 4, 4, 5};

    int acc = 0;
    int milestoneIndex = 0;
    for (int i = 0; i<revenues.length; i++){
      acc += revenues[i];

      // some bug which needs to be identified:
      // while(milestoneIndex < milestones.length && acc >= milestones[milestoneIndex]) {
      //   output[milestoneIndex]=i+1;
      //   milestoneIndex++;
      // }

      // skipping some milestones:
      // if(acc >= milestones[milestoneIndex]) {
      //   output[milestoneIndex]=i+1;
      //   milestoneIndex++;
      // }
    }

    return output;
  }



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
    int revenues_1[] = {100, 200, 300, 400, 500};
    int milestones_1[] = {300, 800, 1000, 1400};
    int expected_1[] = {2, 4, 4, 5};
    int[] output_1 = getMilestoneDays(revenues_1, milestones_1);
    check(expected_1, output_1);

    int revenues_2[] = {700, 800, 600, 400, 600, 700};
    int milestones_2[] = {3100, 2200, 800, 2100, 1000};
    int expected_2[] = {5, 4, 2, 3, 2};
    int[] output_2 = getMilestoneDays(revenues_2, milestones_2);
    check(expected_2, output_2);
 
    // Add your own test cases here
   
  }
 
  public static void main(String[] args) {
    new Solution().run();
  }
}
