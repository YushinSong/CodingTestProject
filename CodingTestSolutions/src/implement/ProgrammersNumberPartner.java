package src.implement;

import java.util.*;

public class ProgrammersNumberPartner {
    class Solution {
        public String solution(String X, String Y) {
            Map<Character, Integer> xCountMap = new TreeMap<>(Collections.reverseOrder());
            Map<Character, Integer> yCountMap = new HashMap<>();

            int index = 0;
            while(index < X.length() || index < Y.length()){
                if(index < X.length()){
                    if(xCountMap.containsKey(X.charAt(index)))
                        xCountMap.put(X.charAt(index), xCountMap.get(X.charAt(index)) + 1);
                    else
                        xCountMap.put(X.charAt(index), 1);
                }
                if(index < Y.length()){
                    if(yCountMap.containsKey(Y.charAt(index)))
                        yCountMap.put(Y.charAt(index), yCountMap.get(Y.charAt(index)) + 1);
                    else
                        yCountMap.put(Y.charAt(index), 1);
                }

                index++;
            }

            String answer = "";
            Iterator<Character> xMapKeys = xCountMap.keySet().iterator();
            while(xMapKeys.hasNext()){
                char key = xMapKeys.next();
                int value = xCountMap.get(key);
                if(!yCountMap.containsKey(key))
                    continue;
                if(answer.length() == 0 && key == '0')
                    return "0";

                int yValue = yCountMap.get(key);
                answer += Character.toString(key).repeat(value < yValue ? value : yValue);
            }

            if(answer.length() == 0)
                return "-1";

            return answer;
        }
    }
}
