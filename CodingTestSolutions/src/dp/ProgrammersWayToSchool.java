package src.dp;

import java.util.*;

public class ProgrammersWayToSchool {
    class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int[][] dp = new int[n][m];
            dp[0][0] = 1;
            for(int[] puddle : puddles)
                dp[puddle[1]-1][puddle[0]-1] = -1;

            for(int i = 0; i < n; ++i){
                for(int j = 0; j < m; ++j){
                    if(dp[i][j] == -1){
                        dp[i][j] = 0;
                        continue;
                    }

                    dp[i][j] += (i != 0 ? dp[i-1][j] % 1000000007 : 0)
                            + (j != 0 ? dp[i][j-1] % 1000000007 : 0);
                }
            }

            return dp[n-1][m-1] % 1000000007;
        }
    }
}
