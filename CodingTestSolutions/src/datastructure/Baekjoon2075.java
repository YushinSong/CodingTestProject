package src.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2075 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; ++i){
            String[] numbers = br.readLine().split(" ");
            for(String number : numbers)
                pq.add(Integer.parseInt(number));
        }

        for(int i = 0; i < N - 1; ++i)
            pq.poll();
        System.out.println(pq.poll());

        br.close();
    }
}
