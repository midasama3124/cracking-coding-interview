class Solution(object):
    def pancakeSort(self, A):
        """
        :type A: List[int]
        :rtype: List[int]
        """
        res = []
        for i in range(len(A)-1, -1, -1):
            k = 0
            while A[k] != i+1: k += 1
            if k == i: continue
            if k != 0:
                self.flip(A, k+1)
                res.append(k+1)
            self.flip(A, i+1)
            res.append(i+1)
        return res

    def flip(self, A, k):
        for i in range(k/2):
            A[i], A[k-1-i] = A[k-1-i], A[i]