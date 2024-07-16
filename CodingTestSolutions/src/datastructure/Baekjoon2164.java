package src.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Baekjoon2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; ++i)
            queue.add(i);

        while(queue.size() != 1){
            queue.poll();
            int topNum = queue.poll();
            queue.add(topNum);
        }
        System.out.println(queue.poll());

        br.close();
    }
}
