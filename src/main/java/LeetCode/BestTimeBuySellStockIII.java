package LeetCode;

public class BestTimeBuySellStockIII {
    // Time Limit Exceeded
//    private static int profitMax;
//    public static int maxProfit(int[] prices) {
//        iterate(prices, false, 0, 0, 2);
//        return profitMax;
//    }

    // Time Limit Exceeded
//    private static void iterate(int[] prices, boolean bought, int idx, int _profit, int numSells) {
//        if (idx >= prices.length) {
//            profitMax = Math.max(profitMax, _profit);
//            return;
//        }
//        // Buy / sell depending on bought
//        if (numSells > 0) {
//            int incrSells = bought ? -1 : 0;
//            int incrProfit = bought ? prices[idx] : -prices[idx];
//            iterate(prices, !bought, idx + 1, _profit + incrProfit, numSells + incrSells);
//        }
//        // Do nothing
//        iterate(prices, bought, idx + 1, _profit, numSells);
//    }

    public static int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int fs = Integer.MIN_VALUE, ss = Integer.MIN_VALUE;
        int fb = Integer.MIN_VALUE, sb = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            fb = Math.max(fb, -prices[i]);
            fs = Math.max(fs, fb + prices[i]);
            sb = Math.max(sb, fs - prices[i]);
            ss = Math.max(ss, sb + prices[i]);
        }
        return ss;
    }

    public static void main(String[] args) {
//        int[] prices = {3,3,5,0,0,3,1,4};
//        int[] prices = {1,2,3,4,5};
        int[] prices = {7,6,4,3,1};
        int res = maxProfit(prices);
        System.out.println(res);
    }
}
