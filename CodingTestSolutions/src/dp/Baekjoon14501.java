package src.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int days = Integer.parseInt(br.readLine());

        int[] reqDay = new int[days]; // 날짜
        int[] pay = new int[days]; // 날짜별 페이
        int[] dp = new int[days + 1]; // dp 메모이제이션

        for(int i = 0; i < days; ++i){
            String[] input = br.readLine().split(" ");
            reqDay[i] = Integer.parseInt(input[0]);
            pay[i] = Integer.parseInt(input[1]);
        }

        for(int i = days - 1; i >= 0; --i){
            if(reqDay[i] > days - i) // 퇴사날짜를 초과하는 상담인 경우
                dp[i] = dp[i+1]; // 아예 할 수 없는 상담. 이전 메모와 같은 값을 메모
            else // 초과하지 않는 경우
                // 상담을 진행했을 시 얻을 수 있는 페이와, 상담날이 끝난 이후 얻을 수 있는 페이를
                // 이전 메모와 비교해 더 큰 값을 메모한다.
                dp[i] = Math.max(pay[i] + dp[i + reqDay[i]], dp[i + 1]);
        }

        System.out.println(dp[0]);

        br.close();
    }

}
