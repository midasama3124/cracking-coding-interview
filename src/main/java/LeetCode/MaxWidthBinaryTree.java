package LeetCode;

import java.util.HashMap;
import java.util.Map;

import static LeetCode.BSTPreorder.TreeNode;

public class MaxWidthBinaryTree {
    static int res;
    static Map<Integer, Integer> map;    // Depth, index
    public static int widthOfBinaryTree(TreeNode root) {
        /* First approach (Time excedeed) */
//        int max = 0;
//        if (root == null) return max;
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//        int _max = -1;   // Maximum number of nodes in each level
//        // Keep searching until width of current level is zero (all elements are null)
//        while(_max != 0) {
//            List<TreeNode> list = new ArrayList<>();
//            _max = 0;
//            while (!q.isEmpty()) {
//                list.add(q.poll());
//            }
//            int count = 1;
//            boolean firstValue = false;
//            for (TreeNode node : list) {
//                if (firstValue) count++;
//                if (node != null) {
//                    _max = count;
//                    firstValue = true;
//                    if (node.left != null) q.add(node.left);
//                    else q.add(null);
//                    if (node.right != null) q.add(node.right);
//                    else q.add(null);
//                } else {
//                    q.add(null);   // Left node
//                    q.add(null);   // Right node
//                }
//            }
//            max = Math.max(max, _max);
//        }
//        return max;
        /* Optimal solution */
        res = 0;
        map = new HashMap<>();
        findWidth(root, 0, 0);
        return res;
    }

    private static void findWidth(TreeNode node, int depth, int index) {
        if (node == null) return;
        map.computeIfAbsent(depth, x -> index);
        res = Math.max(res, index - map.get(depth) + 1);
        if (node.left != null) findWidth(node.left, depth + 1, 2*index + 1);
        if (node.right != null) findWidth(node.right, depth + 1, 2*index + 2);
    }
}
