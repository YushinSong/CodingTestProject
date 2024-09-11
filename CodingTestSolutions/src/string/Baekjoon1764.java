package src.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        Map<String, Boolean> hearMap = new HashMap<>();
        for(int i = 0; i < N; ++i)
            hearMap.put(br.readLine(), true);

        List<String> hearSeeList = new ArrayList<>();
        for(int i = 0; i < M; ++i){
            String seeString = br.readLine();
            if(hearMap.containsKey(seeString))
                hearSeeList.add(seeString);
        }
        Collections.sort(hearSeeList);

        System.out.println(hearSeeList.size());
        for(String hearSee : hearSeeList)
            System.out.println(hearSee);

        br.close();
    }
}
