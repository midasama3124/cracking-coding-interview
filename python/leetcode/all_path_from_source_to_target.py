class Solution(object):
    def allPathsSourceTarget(self, graph):
        """
        :type graph: List[List[int]]
        :rtype: List[List[int]]
        """
        target = len(graph) - 1
        res = []
        queue = []
        queue.append([0])
        while len(queue) != 0:
            path = queue.pop(0)
            lastNode = path[-1]
            if lastNode == target:
                res.append(path)
            else:
                for adj in graph[lastNode]:
                    array = path[:]
                    array.append(adj)
                    queue.append(array)
        return res