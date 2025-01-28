package src.datastructure;

import java.util.*;

public class ProgrammersSaleEvent {
    class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;
            Map<String, Integer> wantMap = new HashMap<>();

            for(int i = 0; i < want.length; ++i)
                wantMap.put(want[i], number[i]);

            int days = 10;
            for(int i = 0; i < discount.length - days + 1; ++i){
                Map<String, Integer> daysMap = new HashMap<>();
                for(int j = i; j < i + days; ++j)
                    daysMap.put(discount[j], daysMap.getOrDefault(discount[j], 0)+1);

                Boolean isMatch = true;
                for(String key : wantMap.keySet()){
                    if(wantMap.get(key) != daysMap.get(key)){
                        isMatch = false;
                        break;
                    }
                }
                answer += isMatch ? 1 : 0;
            }

            return answer;
        }
    }
}
