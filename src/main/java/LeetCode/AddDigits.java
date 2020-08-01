package LeetCode;

public class AddDigits {
    public int addDigits(int num) {
        // First approach (O(n))
        // while (num >= 10) {
        //     int sum = 0;
        //     while (num > 0) {
        //         if (num % 10 != 0) {
        //             sum += num % 10;
        //         }
        //         num /= 10;
        //     }
        //     num = sum;
        // }
        // return num;
        // Mathematical approach
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
}
