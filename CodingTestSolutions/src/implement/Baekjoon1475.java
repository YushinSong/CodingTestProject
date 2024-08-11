package src.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int[] numCount = new int[10];
        for(int i = 0; i < N.length(); ++i){
            int number = Integer.parseInt(String.valueOf(N.charAt(i)));

            if(number == 6) numCount[9]++;
            else numCount[number]++;
        }

        numCount[9] = numCount[9] % 2 == 0 ? numCount[9] / 2 : numCount[9] / 2 + 1;
        System.out.println(Arrays.stream(numCount).max().getAsInt());

        br.close();
    }
}
