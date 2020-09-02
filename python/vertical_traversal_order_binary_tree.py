class Solution(object):
    def verticalTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        self.maxHd = 0
        self.minHd = 0
        self.cache = {}
        # Map binary tree into cache
        self.dfs(root, 0, 0)
        # Remap cache into result list
        res = []
        for key in range(self.minHd, self.maxHd + 1):
            sortedList = self.cache[key]
            sortedList.sort(key = lambda x: (x[1], x[0]))
            vals = []
            for pair in sortedList:
                vals.append(pair[0])
            res.append(vals)
        return res

    def dfs(self, node, hd, vd):
        if not hd in self.cache: self.cache[hd] = []
        self.cache[hd].append([node.val, vd])
        self.minHd = min(self.minHd, hd)
        self.maxHd = max(self.maxHd, hd)
        if node.left: self.dfs(node.left, hd - 1, vd + 1)
        if node.right: self.dfs(node.right, hd + 1, vd + 1)