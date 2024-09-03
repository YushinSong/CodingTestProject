package src.string;

import java.util.*;

public class ProgrammersRoughBuiltKeyboard {
    class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            Map<Character, Integer> alpabetMin = new HashMap<>();

            for(String curkey : keymap){
                for(int i = 0; i < curkey.length(); ++i){
                    char currentChar = curkey.charAt(i);
                    if(alpabetMin.containsKey(currentChar)){
                        if(alpabetMin.get(currentChar) > i + 1)
                            alpabetMin.put(currentChar, i + 1);
                    } else {
                        alpabetMin.put(currentChar, i + 1);
                    }
                }
            }

            int[] answer = new int[targets.length];
            for(int i = 0; i < targets.length; ++i){
                for(int j = 0; j < targets[i].length(); ++j){
                    char currentChar = targets[i].charAt(j);
                    if(!alpabetMin.containsKey(currentChar)){
                        answer[i] = -1;
                        break;
                    }
                    answer[i] += alpabetMin.get(currentChar);
                }
            }

            return answer;
        }
    }
}
