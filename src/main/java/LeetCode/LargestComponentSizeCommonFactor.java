package LeetCode;

import java.util.*;

public class LargestComponentSizeCommonFactor {
    public int largestComponentSize(int[] A) {
        int[] parent = new int[100001];
        for (int i = 0; i < parent.length; i++) parent[i] = -1;
        // Fill up parent array with factors
        for (int x : A) {
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x%i == 0) {
                    _union(i, x, parent);
                    _union(x, x/i, parent);
                }
            }
        }
        // Find maximum component size through a cache
        int count = 0;
        Map<Integer, Integer> cache = new HashMap();
        for (int x : A) {
            int xp = _find(x, parent);
            count = Math.max(count, cache.getOrDefault(xp, 0) + 1);
            cache.put(xp, cache.getOrDefault(xp, 0) + 1);
        }
        return count;
    }

    private int _find(int x, int[] parent) {
        if (parent[x] == -1) return x;
        parent[x] = _find(parent[x], parent);
        return parent[x];
    }

    private void _union(int x, int y, int[] parent) {
        int xp = _find(x, parent);
        int yp = _find(y, parent);
        if (xp != yp) parent[yp] = xp;
    }
}
