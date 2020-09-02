package LeetCode;

import java.util.Arrays;

public class DistributeCandies {
    public static int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int round = 0;
        while (candies > 0) {
            for (int i = 0; i < num_people; i++) {
                int incr = i + round + 1;
                if (incr <= candies) {
                    res[i] += incr;
                    candies -= incr;
                } else {
                    res[i] += candies;
                    candies = 0;
                }
            }
            round += num_people;
        }
        return res;
    }

    public static void main(String[] args) {
//        int candies = 7, num_people = 4;
        int candies = 10, num_people = 3;
        int[] res = distributeCandies(candies, num_people);
        System.out.println(Arrays.toString(res));
    }
}
