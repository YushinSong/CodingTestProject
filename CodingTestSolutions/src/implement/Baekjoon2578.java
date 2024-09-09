package src.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Baekjoon2578 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> bingoMap = new HashMap<>();
        boolean[][] checkMap = new boolean[5][5];
        for(int i = 0; i < 5; ++i){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < 5; ++j){
                bingoMap.put(line[j], String.valueOf(i) + String.valueOf(j));
            }
        }

        int count = 0;
        for(int i = 0; i < 5; ++i){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < 5; ++j){
                count++;
                String[] location = bingoMap.get(line[j]).split("");
                checkMap[Integer.parseInt(location[0])][Integer.parseInt(location[1])] = true;
                if(bingoCount(checkMap) >= 3){
                    System.out.println(count);
                    return;
                }
            }
        }

        br.close();
    }

    public static int bingoCount(boolean[][] checkMap){
        int answer = 0;

        int downCount = 0;
        int upCount = 0;
        for(int i = 0; i < 5; ++i){
            int rowCount = 0;
            int colCount = 0;
            for(int j = 0; j < 5; ++j){
                if(checkMap[i][j])
                    rowCount++;
                if(checkMap[j][i])
                    colCount++;
            }
            if(rowCount == 5) answer++;
            if(colCount == 5) answer++;

            if(checkMap[i][i])
                downCount++;
            if(checkMap[i][4 - i])
                upCount++;
        }
        if(downCount == 5) answer++;
        if(upCount == 5) answer++;

        return answer;
    }
}
