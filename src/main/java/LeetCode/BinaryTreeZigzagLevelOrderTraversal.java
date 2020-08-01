package LeetCode;

import LeetCode.BSTPreorder.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean diagonal = false;
        while(!q.isEmpty()) {
            List<TreeNode> level = new ArrayList<>();
            while(!q.isEmpty()) {
                level.add(q.poll());
            }
            List<Integer> vals = new ArrayList<>();
            for (TreeNode t : level) {
                vals.add(t.val);
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
            }
            if (diagonal) Collections.reverse(vals);
            res.add(vals);
            diagonal = !diagonal;
        }
        return res;
    }
}
