package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

import static LeetCode.BSTPreorder.*;

public class VerticalOrderTraversalBinaryTree {
    int maxHd = Integer.MIN_VALUE, minHd = Integer.MAX_VALUE;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<int[]>> cache = new HashMap<>();
        // Map binary tree into cache
        dfs(root, cache, 0, 0);
        // Remap cache into result list
        List<List<Integer>> res = new ArrayList<>();
        for (int key = minHd; key <= maxHd; key++) {
            List<int[]> sorted = cache.get(key);
            Collections.sort(sorted,
                    (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
            List<Integer> vals = new ArrayList<>();
            for (int[] pair : sorted) {
                vals.add(pair[0]);
            }
            res.add(vals);
        }
        return res;
    }

    private void dfs(TreeNode node, Map<Integer, List<int[]>> cache, int hd, int vd) {
        cache.putIfAbsent(hd, new ArrayList());
        cache.get(hd).add(new int[]{node.val, vd});
        minHd = Math.min(minHd, hd);
        maxHd = Math.max(maxHd, hd);
        if (node.left != null) dfs(node.left, cache, hd - 1, vd + 1);
        if (node.right != null) dfs(node.right, cache, hd + 1, vd + 1);
    }
}
