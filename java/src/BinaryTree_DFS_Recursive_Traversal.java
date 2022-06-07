/* 
Given a binary tree
Task 1: Get traversal (Recursively)
      4
     / \
    7   9
   / \   \
  10  2   6
       \
        6
       /
      2 

*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Set;

class Solution{

  class Node {
      int data;
      Node left;
      Node right;

      public Node(int data) {
        this.data = data;
        this.right = null; 
        this.left = null;
      }

      public Node(int data, Node left, Node right) {
        this.data = data;
        this.right = right; 
        this.left = left;
      }

  }

   public static List<Solution.Node> runBst(Node start){
      List<Node> leftResult;
      List<Node> rightResult;

      if (start.left != null) {
        leftResult = runBst(start.left);
      }

      if (start.right != null) {
        rightResult = runBst(start.right);
      }


      return new ArrayList<Node>(start, leftResult, rightResult);
    }

    public Node createNode() throws IOException {
      
      Node node = new Node(8); 
      node.left = new Node(3); 
      node.right = new Node(10); 
      node.left.left = new Node(1); 
      node.left.right = new Node(6); 
      node.right.right = new Node(14); 
      return node;
    }

    public static void main(String[] args) throws IOException {
      Solution solution = new Solution();
      Solution.Node root = solution.createNode();
      List<Node> traversal = runBst(root);
      for(Node n : traversal){
        System.out.println(n.data);
      } 

    }
}
