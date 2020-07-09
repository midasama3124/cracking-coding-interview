package LeetCode;

public class SumRootLeafNumbers {
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

  private static int sum = 0;

  public static int sumNumbers(TreeNode root) {
    StringBuilder strBld = new StringBuilder();
    dfs(root, strBld);
    return sum;
  }

  public static void dfs(TreeNode node, StringBuilder strBld) {
    // Base case
    if (node == null) return;
    // Recursion
    strBld.append(node.val);
    dfs(node.left, strBld);   // Recursing through left node
    dfs(node.right, strBld);  // Recursing through right node
    if (node.left == null && node.right == null) {
      sum += Integer.parseInt(strBld.toString());
    }
    strBld.deleteCharAt(strBld.length() - 1);
    return;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4,
        new TreeNode (9, new TreeNode(5), new TreeNode(1)),
        new TreeNode(0));
    int sum = sumNumbers(root);
    System.out.println(sum);
  }
}
