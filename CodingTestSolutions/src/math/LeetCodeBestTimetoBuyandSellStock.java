package src.math;

public class LeetCodeBestTimetoBuyandSellStock {
    class Solution {
        public int maxProfit(int[] prices) {
            int min = Integer.MAX_VALUE;
            int maxProfit = 0;
            for(int price : prices){
                maxProfit = price-min > 0 ? Math.max(price-min, maxProfit) : maxProfit;
                min = Math.min(price, min);
            }

            return maxProfit;
        }
    }
}
