package src.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        Map<String, Boolean> sMap = new HashMap<>();
        for(int i = 0; i < N; ++i)
            sMap.put(br.readLine(), true);

        int count = 0;
        for(int i = 0; i < M; ++i){
            String check = br.readLine();
            if(sMap.containsKey(check))
                count++;
        }
        System.out.println(count);

        br.close();
    }
}
