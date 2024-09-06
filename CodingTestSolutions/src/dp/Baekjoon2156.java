package src.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] wines = new int[n + 1]; // 포도주
        int[] dp = new int[n + 1]; // dp 메모이제이션

        for(int i = 1; i <= n; ++i)
            wines[i] = Integer.parseInt(br.readLine());

        dp[1] = wines[1];
        for(int i = 2; i <= n; ++i){
            if(i == 2) dp[2] = dp[1] + wines[2];
            else dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wines[i], dp[i-3] + wines[i] + wines[i-1]));
        }

        System.out.println(dp[n]);

        br.close();
    }
}
