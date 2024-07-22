package src.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Baekjoon25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> game = new HashMap<>(){{
            put("Y", 1);
            put("F", 2);
            put("O", 3);
        }};
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        String gameKind = firstLine[1];

        Set<String> namesSet = new HashSet<>();

        for(int i = 0; i < N; ++i){
            namesSet.add(br.readLine());
        }
        System.out.println(namesSet.size() / game.get(gameKind));

        br.close();
    }
}
