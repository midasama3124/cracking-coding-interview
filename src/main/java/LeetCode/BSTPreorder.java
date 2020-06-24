package LeetCode;

public class BSTPreorder {
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

  public static TreeNode bstFromPreorder(int[] preorder) {
    if (preorder.length == 0) return null;
    // Root node
    TreeNode root = new TreeNode(preorder[0]);
    if (preorder.length == 1) return root;
    // Larger BSTs
    preorderAllocate(preorder, 1, root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    return root;
  }

  // Time complexity: O(N), N: Tree Height
  private static int preorderAllocate(int[] preorder, int pos, TreeNode curr, int min, int max) {
    // Base case and boundaries
    if (pos == preorder.length ||
        preorder[pos] < min ||
        preorder[pos] > max)
      return pos;
    // Check if current value fits left node of current node
    if (preorder[pos] < curr.val) {
      curr.left = new TreeNode(preorder[pos++]);
      pos = preorderAllocate(preorder, pos, curr.left, min, curr.val-1);
    }
    // Recheck base case and boundaries due to previous recursive call
    if (pos == preorder.length ||
        preorder[pos] < min ||
        preorder[pos] > max)
      return pos;
    // Check if current value fits right node of current node
    curr.right = new TreeNode(preorder[pos++]);
    pos = preorderAllocate(preorder, pos, curr.right, curr.val+1, max);
    return pos;
  }

  public static void main(String[] args) {
    int[] preorder = {8, 5, 1, 7, 10, 12};
    TreeNode root = bstFromPreorder(preorder);
  }
}
