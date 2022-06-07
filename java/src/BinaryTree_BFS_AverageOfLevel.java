/* 
Given a binary tree
 Task 1: get the average value at each level of the tree

      4
     / \
    7   9
   / \   \
  10  2   6
       \
        6
       /
      2 
BST
*/
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

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

   public static List<Double> runBst(Node start){
      ArrayDeque<Node> next_queue = new ArrayDeque<Node>();
      ArrayDeque<Node> current_queue = new ArrayDeque<Node>();
      List<Double> avgs = new ArrayList<Double>();

      next_queue.add(start);
      while (!next_queue.isEmpty()){
        current_queue=next_queue.clone();
        next_queue.clear();
        Node node;
        double sum = 0;
        double avg = 0.0;
        int queue_size=current_queue.size();
        while (!current_queue.isEmpty()){

          node = current_queue.poll();
          sum = sum + node.data;
          if(node.left != null){
            next_queue.add(node.left);
          }
          if(node.right != null){
            next_queue.add(node.right);
          }
        }
          avg = sum/queue_size;
          avgs.add(avg);
      }
      return avgs;
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
      List<Double> avgs = runBst(root);
      System.out.println(avgs);
      

    }
}
