class Solution(object):

    def __init__(self, rects):
        """
        :type rects: List[List[int]]
        """
        self.numPts = 0;
        self.rectCumCount = []
        self.rects = rects;
        for rect in rects:
            self.numPts += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1)
            self.rectCumCount.append(self.numPts)

    def pick(self):
        """
        :rtype: List[int]
        """
        ptIdx = random.randint(0, self.numPts - 1)
        l = 0; r = len(self.rects) - 1
        # Binary search
        while l < r:
            mid = l + (r-l)/2
            if self.rectCumCount[mid] <= ptIdx: l = mid + 1
            else: r = mid
        # l : rectangle index
        rect = self.rects[l]
        xPts = rect[2] - rect[0] + 1
        yPts = rect[3] - rect[1] + 1
        ptsInRect = xPts * yPts
        ptStart = self.rectCumCount[l] - ptsInRect
        offset = ptIdx - ptStart
        return [rect[0] + offset%xPts, rect[1] + offset/xPts]



# Your Solution object will be instantiated and called as such:
# obj = Solution(rects)
# param_1 = obj.pick()