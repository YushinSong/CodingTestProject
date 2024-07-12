package src.basics;

import java.util.Scanner;

public class Baekjoon2501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int count = 0;
        for(int num = 1; num <= N; ++num){
            if(N % num == 0) count++;

            if(count == K){
                System.out.println(num);
                break;
            }
            if(num == N)System.out.println(0);
        }

        sc.close();
    }
}
