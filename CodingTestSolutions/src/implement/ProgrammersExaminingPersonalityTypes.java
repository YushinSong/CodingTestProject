package src.implement;
import java.util.*;

public class ProgrammersExaminingPersonalityTypes {
    class Solution {
        public String solution(String[] survey, int[] choices) {
            Map<String, Integer> map = new HashMap<>();
            map.put("RT", 0); map.put("CF", 0);
            map.put("JM", 0); map.put("AN", 0);

            for(int i = 0; i < survey.length; ++i){
                int score = choices[i] - 4;

                switch(survey[i]){
                    case "RT" -> map.put("RT", map.get("RT") + score);
                    case "TR" -> map.put("RT", map.get("RT") - score);
                    case "CF" -> map.put("CF", map.get("CF") + score);
                    case "FC" -> map.put("CF", map.get("CF") - score);
                    case "JM" -> map.put("JM", map.get("JM") + score);
                    case "MJ" -> map.put("JM", map.get("JM") - score);
                    case "AN" -> map.put("AN", map.get("AN") + score);
                    case "NA" -> map.put("AN", map.get("AN") - score);
                }
            }

            String answer = "";
            for(String key : map.keySet()){
                int value = map.get(key);

                if(value <= 0)  answer += key.charAt(0);
                else            answer += key.charAt(1);
            }

            return answer;
        }
    }
}
