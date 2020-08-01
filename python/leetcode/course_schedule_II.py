class Solution:
    def dfs(self, u: int):
        self.visited[u] = 1
        for v in self.adj[u]:
            if self.visited[v] == 1: return True
            if self.visited[v] == 0 and self.dfs(v): return True
        self.visited[u] = 2
        self.s.append(u)
        return False

    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        # Adjacency graph
        self.adj = [[] for i in range(numCourses)]
        # Populate graph
        for pair in prerequisites:
            self.adj[pair[1]].append(pair[0])
        # Topological sort stack
        self.s = []
        # Array storing visited flags
        # 0: Not visited
        # 1: Is being visited
        # 2: Has already been visited and pushed into stack
        self.visited = [0]*numCourses
        # Recurse using dfs for every edge and its adjacents
        for i in range(numCourses):
            if self.visited[i] == 0 and self.dfs(i): return []
        self.s.reverse()
        return self.s