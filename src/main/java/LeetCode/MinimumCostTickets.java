package LeetCode;

public class MinimumCostTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n+1];
        for (int i = 0; i < n; i++) dp[i] = 365 * costs[0];
        for (int i = n - 1; i >= 0; i--) {
            int idx7 = i, idx30 = i;
            while (idx7 < n && days[idx7] < days[i] + 7) idx7++;
            while (idx30 < n && days[idx30] < days[i] + 30) idx30++;
            dp[i] = Math.min(dp[i+1] + costs[0], Math.min(dp[idx7] + costs[1], dp[idx30] + costs[2]));
        }
        return dp[0];
    }
}
