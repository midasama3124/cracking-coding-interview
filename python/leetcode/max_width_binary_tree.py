def widthOfBinaryTree(self, root: TreeNode) -> int:
        if root == None: return 0
        res = 1
        q = []
        q.append([root, 0])
        while len(q) > 0:
            count = len(q)
            start = q[0][1]
            end = q[-1][1]
            res = max(res, end-start+1)
            for i in range(count):
                p = q.pop(0)
                idx = p[1] - start
                if p[0].left != None:
                    q.append([p[0].left, idx*2 + 1])
                if p[0].right != None:
                    q.append([p[0].right, idx*2 + 2])
        return res