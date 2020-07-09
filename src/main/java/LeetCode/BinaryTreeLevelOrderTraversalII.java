package LeetCode;

import LeetCode.BSTPreorder.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
  public static List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      List<Integer> nodes = new ArrayList<>();
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        nodes.add(node.val);
        if (node.left != null) q.add(node.left);
        if (node.right != null) q.add(node.right);
      }
      res.add(0, nodes);
    }
    return res;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(
        3,
        new TreeNode(9),
        new TreeNode(
            20,
            new TreeNode(15),
            new TreeNode(7)
        ));
    List<List<Integer>> res = levelOrderBottom(root);
    System.out.println(res.toString());
  }
}
