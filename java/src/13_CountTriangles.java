import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
// Add any extra import statements you may need here


class Solution {

  class Sides{
    int a;
    int b;
    int c;
    Sides(int a,int b,int c){
      this.a = a;
      this.b = b;
      this.c = c;
    }
  }

  public static int [] quicksort(int [] array){    
    array = Arrays.stream(array).sorted().toArray();
    return array;
  }


  public static int countDistinctTrianglesSolution1(ArrayList<Sides> arr) {
    int [] array = new int [3];
    Set<Integer> triangles = new HashSet<Integer>();
    int [] sides;

    for (int i=0; i<arr.size(); i++){
      array[0] = arr.get(i).a;
      array[1] = arr.get(i).b;
      array[2] = arr.get(i).c;

      sides = quicksort(array);
      triangles.add(sides[0] *100 + sides[1] *10 +  sides[2]);
    }

    return triangles.size();
  }



  public static int countDistinctTrianglesSolution2(ArrayList<Sides> arr) {
    int [] array = new int [3];
    ArrayList<Integer> triangles = new ArrayList<Integer>();
    int numberTriangles=0;
    int indexDuplicate;
    int searchVal;
    int [] sides;

    for (int i=0; i<arr.size(); i++){
      array[0] = arr.get(i).a;
      array[1] = arr.get(i).b;
      array[2] = arr.get(i).c;

      sides = quicksort(array);
      triangles.add(sides[0] *100 + sides[1] *10 +  sides[2]);
    }

    while(triangles.size()>0){
      searchVal = triangles.get(0);
      numberTriangles++;
      while ((indexDuplicate = triangles.indexOf(searchVal)) != -1){
        triangles.remove(indexDuplicate);
      }
    }

    return numberTriangles;
  }

  public static int binarySearch(ArrayList<Integer> list, int searchValue){
    int high = list.size()-1;
    int low = 0;
    int mid;

    while (low<=high){

      mid =  (high+low)/2;

      System.out.println(low  + " "  + mid + " " + high);

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

  public static int countDistinctTrianglesSolution3(ArrayList<Sides> arr) {
    int [] array = new int [3];
    ArrayList<Integer> triangles = new ArrayList<Integer>();
    int numberTriangles=0;
    int indexDuplicate;
    int searchVal;
    int [] sides;

    for (int i=0; i<arr.size(); i++){
      array[0] = arr.get(i).a;
      array[1] = arr.get(i).b;
      array[2] = arr.get(i).c;

      sides = quicksort(array);
      triangles.add(sides[0] *100 + sides[1] *10 +  sides[2]);
    }

    Collections.sort(triangles);
    while(triangles.size()>0){
      searchVal = triangles.get(0);
      numberTriangles++;
      while ((indexDuplicate = binarySearch(triangles, searchVal)) != -1){
        triangles.remove(indexDuplicate);
      }
    }

    return numberTriangles;
  }




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
    ArrayList<Sides> arr_1 = new ArrayList<>();
    arr_1.add(new Sides(7, 6, 5));
    arr_1.add(new Sides(5, 7, 6));
    arr_1.add(new Sides(8, 2, 9));
    arr_1.add(new Sides(2, 3, 4));
    arr_1.add(new Sides(2, 4, 3));
    int expected_1 = 3;
    int output_1 = countDistinctTrianglesSolution3(arr_1);
    check(expected_1, output_1);

    ArrayList<Sides> arr_2 = new ArrayList<>();
    arr_2.add(new Sides(3, 4, 5));
    arr_2.add(new Sides(8, 8, 9));
    arr_2.add(new Sides(3, 5, 4));
    arr_2.add(new Sides(9, 8, 1));
    int expected_2 = 3;
    int output_2 = countDistinctTrianglesSolution3(arr_2);
    check(expected_2, output_2);

    // Add your own test cases here

  }

  public static void main(String[] args) {
    new Solution().run();
  }
}

