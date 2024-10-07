package src.string;

public class ProgrammersRepeatBinaryFormat {
    class Solution {
        public int[] solution(String s) {
            int[] answer = new int[2];

            while(!s.equals("1")){
                int zeroCount = 0;
                for(int i = 0; i < s.length(); ++i)
                    zeroCount += s.charAt(i) == '0' ? 1 : 0;

                s = Integer.toBinaryString(s.length() - zeroCount);
                answer[0]++;
                answer[1] += zeroCount;
            }

            return answer;
        }
    }
}
