/* 
Given a binary tree
Task 1: Get traversal (Pre Order - DLR  using Queue, Breadth First Search)

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
import java.util.Queue;
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
      Queue<Node> queue = new LinkedList<Node>();
      // Set<Node> seen = new HashSet<>();
      List<Node> seen = new ArrayList<Node>();
      List<Integer> avg = new ArrayList<Integer>();

      queue.add(start);
      while (!queue.isEmpty()){
        Node current = queue.poll();
        if (!seen.contains(current)){
          seen.add(current);
        }
        if((current.left != null) && !seen.contains(current.left)){
            queue.add(current.left);
        }
        if((current.right != null) && !seen.contains(current.right)){
            queue.add(current.right);
        }  
      }
      return seen;
    }

    public Node createNode() throws IOException {
      
      Node node = new Node(8); 
      node.left = new Node(3); 
      node.right = new Node(10); 
      node.left.left = new Node(1); 
      node.left.right = new Node(6); 
      node.right.right = new Node(14); 
      // int expected = 4;
      // int output = runBst(root);

      // Node node1 = new Node(
      //   4,
      //   new Node(2, new Node(1), new Node(5, null, new Node(7))),
      //   new Node(
      //     3,
      //     new Node(
      //       8,
      //       new Node(
      //         3,
      //         new Node(1),
      //         null
      //       )
      //       , null
      //     ),
      //     new Node(2))
      // );

      // Node node2 = new Node(
      //   4,
      //   new Node(7, new Node(10), new Node(2, null, new Node(6, new Node(2), null))),
      //   new Node(9, null, new Node(6))
      // );

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
