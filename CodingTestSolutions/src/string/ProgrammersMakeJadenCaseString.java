package src.string;

import java.util.*;

public class ProgrammersMakeJadenCaseString {
    class Solution {
        public String solution(String s) {
            String answer = "";

            for(String word : s.split(" ")){
                if(word.length() == 0)
                    answer += " ";
                else
                    answer += word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ";
            }

            if(s.charAt(s.length() - 1) == ' ')
                return answer;

            return answer.substring(0, answer.length() - 1);
        }
    }
}
