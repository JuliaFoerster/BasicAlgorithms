import java.io.*;
import java.util.*;
// Add any extra import statements you may need here

import javax.crypto.KeyAgreement;

import org.apache.commons.lang3.ObjectUtils.Null;

class Heap{

  private int [] array;
  private int size;

  public Heap(){
    array = new int[100000];
    size = 0;
  }

  public void add(int element){
    array[size]=element;

    // Sift up
    int kid =size;
    while(kid>0){
      int parentIndex = (kid -1)/2;
      if (element>array[parentIndex]){
        int temp=array[parentIndex];
        array[parentIndex]=element;
        array[kid]=temp;
        kid=parentIndex;
      }
      else{
        break;
      }
    }
    size = size + 1;
  }


  public int poll(){
    int root = array[0];
    int p=0;
    int l;
    int r;
    
    // Sift down
    array[0]=array[array.length-1];
    array[array.length-1] = 0;// should be deleted?

    
    while(p<size-2){
      l = 2 * p+1;
      r = 2 * p+2;

      if (array[l] > array[r]){
        if (array[p] > array[l]){
          int temp=array[l];
          array[l] =array[p];
          array[p]=temp;      
        }
        else{
          break;
        }
      }

      else if (array[l] < array[r]){
        if (array[p] > array[r]){
          int temp=array[r];
          array[r] =array[p];
          array[p]=temp;     
        }
        else{
          break;
        }
      }

    }
    return root;
  }
}


class Solution {


  public static int[] findMaxProduct(int[] arr) {
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Comparator.reverseOrder());
    // Heap heap = new Heap();
    int [] output = new int[arr.length];
    heap.add(arr[0]);
    heap.add(arr[1]);
    for (int i=2; i<arr.length; i++){
      heap.add(arr[i]);
      int ind_0 = heap.poll();
      int ind_1 = heap.poll();
      int ind_2 = heap.poll();
      output[i]=ind_0*ind_1*ind_2;
      heap.add(ind_0);
      heap.add(ind_1);
      heap.add(ind_2);
    }
    output[0]=-1;
    output[1]=-1;
    
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
    int[] arr_1 = {1, 2, 3, 4, 5};
    int[] expected_1 = {-1, -1, 6, 24, 60};
    int[] output_1 = findMaxProduct(arr_1);
    check(expected_1, output_1);
   
    // int[] arr_2 = {2, 4, 7, 1, 5, 3};
    // int[] expected_2 = {-1, -1, 56, 56, 140, 140};
    // int[] output_2 = findMaxProduct(arr_2);
    // check(expected_2, output_2);
 
    // Add your own test cases here
   
  }
 
  public static void main(String[] args) {
    new Solution().run();
  }
}
