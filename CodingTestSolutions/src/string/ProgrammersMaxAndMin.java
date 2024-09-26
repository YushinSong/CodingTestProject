package src.string;

public class ProgrammersMaxAndMin {
    class Solution {
        public String solution(String s) {
            String[] split = s.split(" ");

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(String st : split){
                min = Math.min(min, Integer.parseInt(st));
                max = Math.max(max, Integer.parseInt(st));
            }

            return String.valueOf(min) + " " + String.valueOf(max);
        }
    }
}
