package LeetCode;

public class ReverseBinary {
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            if((n & 1) > 0) res++;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int input = 239817;
        int res = reverseBits(input);
        System.out.println(res);
    }
}
