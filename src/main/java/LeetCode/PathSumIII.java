package LeetCode;

import java.util.*;

import static LeetCode.BSTPreorder.*;

public class PathSumIII {

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumHelper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private static int pathSumHelper(TreeNode node, int sum) {
        if (node == null) return 0;
        int res = 0;
        if (node.val == sum) res++;
        res += pathSumHelper(node.left, sum - node.val);
        res += pathSumHelper(node.right, sum - node.val);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10,
                new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11)));
        int sum = 8;
        int sumPaths = pathSum(root, sum);
        System.out.println(sumPaths);
    }
}
