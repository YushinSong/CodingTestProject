package src.string;

public class ProgrammersMakeStrangeWord {
    class Solution {
        public String solution(String s) {
            String answer = "";
            int indexCount = 0;
            for(String split : s.split("")){
                if(split.equals(" ")){
                    indexCount = 0;
                    answer += " ";
                    continue;
                }

                answer += indexCount%2==0 ? split.toUpperCase() : split.toLowerCase();
                indexCount++;
            }
            return answer;
        }
    }
}
