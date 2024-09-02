package src.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        String[] numbers = br.readLine().split(" ");

        int sum = 0;
        int[] restArr = new int[1000];
        long count = 0;

        for(int i = 0; i < N; ++i){ // N번만큼 반복
            int currentNum = Integer.parseInt(numbers[i]);
            sum += currentNum; // 누적합 계산
            sum %= M; // 현재까지의 누적합의 나머지 계산
            count += restArr[sum]; // 현재 누적합의 나머지만큼이 이전에 이만큼 나온적이 있었다.
            restArr[sum]++; // 나머지 기록
            if(sum == 0)
                count++;
        }

        System.out.println(count);

        br.close();
    }

}
