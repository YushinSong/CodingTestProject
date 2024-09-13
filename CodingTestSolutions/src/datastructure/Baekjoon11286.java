package src.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baekjoon11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return Math.abs(a) - Math.abs(b) == 0 ? a-b : Math.abs(a) - Math.abs(b);
            }
        });

        for(int i = 0; i < N; ++i){
            int input = Integer.parseInt(br.readLine());
            if(input != 0)
                pq.add(input);
            else{
                if(pq.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(pq.poll());
            }
        }

        br.close();
    }
}
