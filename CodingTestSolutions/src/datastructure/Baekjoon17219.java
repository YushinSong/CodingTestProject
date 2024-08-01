package src.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);

        Map<String, String> pwMap = new HashMap<>();
        for(int i = 0; i < N; ++i){
            String[] line = br.readLine().split(" ");
            pwMap.put(line[0], line[1]);
        }
        for(int i = 0; i < M; ++i)
            System.out.println(pwMap.get(br.readLine()));

        br.close();
    }
}
