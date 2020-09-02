package LeetCode;

import LeetCode.BSTPreorder.TreeNode;

public class DeleteNodeBTS {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (key > root.val) root.right = deleteNode(root.right, key);
        else if (key < root.val) root.left = deleteNode(root.left, key);
        else {   // Key was found
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left != null) {
                root.val = inorderPredecessor(root);
                root.left = deleteNode(root.left, root.val);
            } else {   // Right node is present
                root.val = inorderSuccessor(root);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    private int inorderPredecessor(TreeNode node) {
        node = node.left;
        while (node.right != null) node = node.right;
        return node.val;
    }

    private int inorderSuccessor(TreeNode node) {
        node = node.right;
        while (node.left != null) node = node.left;
        return node.val;
    }
}
