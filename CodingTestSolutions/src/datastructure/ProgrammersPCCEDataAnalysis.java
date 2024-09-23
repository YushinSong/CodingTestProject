package src.datastructure;

import java.util.*;

public class ProgrammersPCCEDataAnalysis {
    class Solution {
        public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
            Map<String, Integer> dataMap = new HashMap<>();
            dataMap.put("code", 0);
            dataMap.put("date", 1);
            dataMap.put("maximum", 2);
            dataMap.put("remain", 3);

            int tempIndex = 0;
            int[][] temp = new int[data.length][4];
            for(int i = 0; i < data.length; ++i){
                if(data[i][dataMap.get(ext)] < val_ext){
                    temp[tempIndex] = data[i];
                    tempIndex++;
                }
            }
            int[][] answer = new int[tempIndex][4];
            for(int i = 0; i < answer.length; ++i){
                answer[i] = temp[i];
            }

            Arrays.sort(answer, (a, b) -> a[dataMap.get(sort_by)] - b[dataMap.get(sort_by)]);

            return answer;
        }
    }
}
