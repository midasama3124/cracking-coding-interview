package LeetCode;

import LeetCode.BSTPreorder.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeInorderPostorderTraversal {
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return contructTreeFromInPost(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    public TreeNode contructTreeFromInPost(int[] inorder, int[] postorder, int start, int end, int idx) {
        if (start > end) return null;
        TreeNode root = new TreeNode(postorder[idx]);
        int rootIdx = inOrderMap.get(postorder[idx]);
        root.right = contructTreeFromInPost(inorder, postorder, rootIdx + 1, end, idx - 1);
        root.left = contructTreeFromInPost(inorder, postorder, start, rootIdx - 1, idx - (end - rootIdx) - 1);
        return root;
    }
}
