import java.io.*; 
import java.util.*;
import java.util.ArrayList;
// Add any extra import statements you may need here


class Solution {

  class Node {
    int data; 
    Node left; 
    Node right; 
    Node() {
      this.data = 0; 
      this.left = null; 
      this.right = null; 
    }
    Node(int data) {
      this.data = data; 
      this.left = null; 
      this.right = null; 
    }
  }




   public static Hashtable<Integer, ArrayList<Integer>> visibleNodes(Node root, Hashtable<Integer, ArrayList<Integer>> tree, int depth) {
     if (root == null){
       return tree;
     }

    ArrayList<Integer> root_data = tree.get(depth);

    if (root_data==null){
     root_data = new ArrayList<Integer>(); 
    }

    root_data.add(root.data);
    tree.put(depth, root_data);

    visibleNodes(root.left, tree, depth+1);
    visibleNodes(root.right, tree, depth+1);
    
    return tree;
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
  public void run() throws IOException {
    
    Node root_1 = new Node(8); 
    root_1.left = new Node(3); 
    root_1.right = new Node(10); 
    root_1.left.left = new Node(1); 
    root_1.left.right = new Node(6); 
    root_1.right.right = new Node(14); 
    root_1.left.right.left = new Node(4); 
    root_1.left.right.right = new Node(7); 
    root_1.right.right.left = new Node(13); 
    // int expected_1 = 4;
    Hashtable<Integer, ArrayList<Integer>> tree = new Hashtable<Integer, ArrayList<Integer>>();
    tree = visibleNodes(root_1, tree, 0);
    System.out.println(tree);
    // check(expected_1, output_1);

    // Node root_2 = new Node(10); 
    // root_2.left = new Node(8);
    // root_2.right = new Node(15);
    // root_2.left.left = new Node(4);
    // root_2.left.left.right = new Node(5);
    // root_2.left.left.right.right = new Node(6);
    // root_2.right.left = new Node(14);
    // root_2.right.right = new Node(16);

    // int expected_2 = 5;
    // int output_2 = visibleNodes(root_2);
    // check(expected_2, output_2);
  
    // Add your own test cases here
    
  }
  public static void main(String[] args) throws IOException {
    new Solution().run();
  }
}
