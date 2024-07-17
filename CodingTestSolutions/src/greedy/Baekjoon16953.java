package src.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Baekjoon16953 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        int count = 0;
        while(B > A){
            if(B % 10 == 1)     B = B / 10;
            else if(B % 2 == 0) B /= 2;
            else                B = -1;
            count++;
        }
        if(A != B) B = -1;
        System.out.println((B == -1) ? B : count + 1);

        br.close();
    }
}
