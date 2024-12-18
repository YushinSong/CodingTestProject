package src.greedy;

public class LeetCodeBestTimetoBuyandSellStockII {
    class Solution {
        public int maxProfit(int[] prices) {
            int answer = 0;
            for(int i = 1; i < prices.length; ++i){
                answer += prices[i-1] < prices[i] ? prices[i] - prices[i-1] : 0;
            }
            return answer;
        }
    }
}
