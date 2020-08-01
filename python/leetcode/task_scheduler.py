class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        same_tasks = {}
        for c in tasks:
            if c in same_tasks:
                same_tasks[c] += 1
            else:
                same_tasks[c] = 1
        max_heap = []
        for i in same_tasks.values():
            heapq.heappush(max_heap, -i)
        cycles = 0
        while len(max_heap) != 0:
            temp = []
            for i in range(n+1):
                if len(max_heap) != 0:
                    temp.append(-heapq.heappop(max_heap))
            for i in temp:
                i -= 1
                if i > 0: heapq.heappush(max_heap, -i)
            if len(max_heap) == 0:
                cycles += len(temp)
            else:
                cycles += n + 1
        return cycles