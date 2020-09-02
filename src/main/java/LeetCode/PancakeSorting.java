package LeetCode;

public class PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList();
        int n = A.length;
        for (int i = n-1; i >= 0; i--) {
            int k = 0;
            while (A[k] != i+1) k++;
            if (k == i) continue;
            if (k != 0) {
                flip(A, k+1);
                res.add(k+1);
            }
            flip(A, i+1);
            res.add(i+1);
        }
        return res;
    }

    private void flip(int[] A, int k) {
        for (int i = 0; i < k/2; i++) {
            int tmp = A[i];
            A[i] = A[k-1-i];
            A[k-1-i] = tmp;
        }
    }
}
