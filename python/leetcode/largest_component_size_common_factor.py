class Solution(object):
    def largestComponentSize(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        self.parent = [-1] * 100001
        # Fill up parent array with factors
        for x in A:
            for i in range(2, int(sqrt(x)) + 1):
                if x%i == 0:
                    self._union(i, x)
                    self._union(x, x/i)
        # Find maximum component size through a cache
        count = 0
        cache = {}
        for x in A:
            xp = self._find(x)
            count = max(count, cache.get(xp, 0) + 1)
            cache[xp] = cache.get(xp, 0) + 1
        return count

    def _find(self, x):
        if self.parent[x] == -1: return x
        self.parent[x] = self._find(self.parent[x])
        return self.parent[x]

    def _union(self, x, y):
        xp = self._find(x)
        yp = self._find(y)
        if xp != yp: self.parent[yp] = xp