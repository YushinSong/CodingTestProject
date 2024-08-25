package src.string;

public class ProgrammersMaxAndMinValue {
    class Solution {
        public String solution(String s) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(String num : s.split(" ")){
                int parNum = Integer.parseInt(num);
                if(min > parNum) min = parNum;
                if(max < parNum) max = parNum;
            }

            return min + " " + max;
        }
    }
}
