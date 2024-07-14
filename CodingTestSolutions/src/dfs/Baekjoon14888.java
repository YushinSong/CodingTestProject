package src.dfs;

import java.util.Scanner;

public class Baekjoon14888 {
    private static int N;
    private static int maxValue = Integer.MIN_VALUE;
    private static int minValue = Integer.MAX_VALUE;
    private static int[] numArr;
    private static int[] operators = new int[4];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        numArr = new int[N];
        for(int i = 0; i < N; ++i)
            numArr[i] = sc.nextInt();
        for(int i = 0; i < 4; ++i){
            operators[i] = sc.nextInt();
        }

        recursive(numArr[0], 1);

        System.out.println(maxValue);
        System.out.println(minValue);

        sc.close();
    }

    public static void recursive(int num, int index){
        if(index == N){
            maxValue = Math.max(num, maxValue);
            minValue = Math.min(num, minValue);
            return;
        }

        for(int i = 0; i < operators.length; i++){
            if(operators[i] > 0){
                operators[i]--; // dfs 알고리즘. 이미 노드를 방문했다고 표시하기

                switch (i){
                    case 0:
                        recursive(num + numArr[index], index + 1);
                        break;
                    case 1:
                        recursive(num - numArr[index], index + 1);
                        break;
                    case 2:
                        recursive(num * numArr[index], index + 1);
                        break;
                    case 3:
                        recursive(num / numArr[index], index + 1);
                        break;
                }

                operators[i]++; // 재귀가 끝났다면, 연산자가 한번은 다 쓰인 상태. 노드 방문 표시 풀기.
            }
        }
    }
}