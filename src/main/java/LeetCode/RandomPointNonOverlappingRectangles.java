package LeetCode;

import java.util.*;

public class RandomPointNonOverlappingRectangles {
    int numPts;
    List<Integer> rectCumCount;
    int[][] rects;


    public RandomPointNonOverlappingRectangles(int[][] rects) {
        numPts = 0;
        rectCumCount = new ArrayList();
        this.rects = rects;
        for (int[] rect : rects) {
            numPts += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            rectCumCount.add(numPts);
        }
    }

    public int[] pick() {
        int ptIdx = (int)(Math.random() * numPts);
        int l = 0, r = rects.length - 1;
        // Binary search
        while(l < r) {
            int mid = l + (r-l)/2;
            if(rectCumCount.get(mid) <= ptIdx) l = mid + 1;
            else r = mid;
        }
        // l : rectangle index
        int[] rect = rects[l];
        int xPts = rect[2] - rect[0] + 1;
        int yPts = rect[3] - rect[1] + 1;
        int ptsInRect = xPts * yPts;
        int ptStart = rectCumCount.get(l) - ptsInRect;
        int offset = ptIdx - ptStart;
        return new int[] {rect[0] + offset%xPts, rect[1] + offset/xPts};
    }
}
