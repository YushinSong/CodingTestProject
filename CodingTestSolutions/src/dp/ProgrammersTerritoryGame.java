package src.dp;

public class ProgrammersTerritoryGame {
    class Solution {
        int solution(int[][] land) {
            int[][] dp = new int[land.length+1][4];
            dp[0] = land[0];

            for(int i = 1; i < land.length; ++i){
                dp[i][0] = land[i][0] + Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][3]));
                dp[i][1] = land[i][1] + Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][3]));
                dp[i][2] = land[i][2] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][3]));
                dp[i][3] = land[i][3] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
            }

            int answer = 0;
            for(int lastNums : dp[land.length-1])
                answer = Math.max(answer, lastNums);

            return answer;
        }
    }
}
