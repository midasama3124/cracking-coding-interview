package LeetCode;

import java.util.LinkedList;

public class KthSmallest {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  // Find k-th smallest element in BTS using DFS (in-order traversal)
  /*public static int kthSmallest(TreeNode root, int k) {
    if (root == null) return 0;   // Base case
    ArrayList<Integer> array = inOrderTraversal(root, new ArrayList<Integer>());
    return array.get(k-1);
  }

  public static ArrayList<Integer> inOrderTraversal(TreeNode node, ArrayList<Integer> array) {
    if (node == null) return array;
    // Traverse left subtree
    inOrderTraversal(node.left, array);
    // Visit root node
    array.add(node.val);
    // Traverse right subtree
    inOrderTraversal(node.right, array);
    return array;
  }*/

  // Find kth smallest element by using iteration and a stack
  public static int kthSmallest(TreeNode root, int k) {
    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

    while (true) {
      while (root != null) {
        stack.add(root);
        root = root.left;
      }
      root = stack.removeLast();
      if (--k == 0) return root.val;
      root = root.right;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5,
        new TreeNode (3,
          new TreeNode (2,
              new TreeNode(1), null),
          new TreeNode(4)),
        new TreeNode(6));
    int k = 5;
    System.out.println(kthSmallest(root, k));
  }
}
