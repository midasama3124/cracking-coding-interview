class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        if (k == len(nums)): return nums

        count = Counter(nums)

        return heapq.nlargest(k, count.keys(), key=count.get)
