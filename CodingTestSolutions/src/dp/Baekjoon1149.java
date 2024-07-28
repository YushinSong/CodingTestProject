package src.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][3]; // [집 위치][색깔]

        for(int i = 1; i <= N; ++i){
            String[] readLine = br.readLine().split(" ");
            int rCost = Integer.parseInt(readLine[0]);
            int gCost = Integer.parseInt(readLine[1]);
            int bCost = Integer.parseInt(readLine[2]);

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rCost; // 빨간색이 겹치지 않는 최소비용
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + gCost; // 초록색이 겹치지 않는 최소비용
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + bCost; // 파란색이 겹치지 않는 최소비용
        }
        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));

        br.close();
    }
}
