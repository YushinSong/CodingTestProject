package src.string;

public class LeetCodeZigzagConversion {
    class Solution {
        public String convert(String s, int numRows) {
            if(numRows==1 || numRows==s.length()) return s;
            StringBuilder[] zigzag = new StringBuilder[numRows];
            for(int i = 0; i < zigzag.length; ++i) zigzag[i] = new StringBuilder();

            int curRow = 0;
            boolean isDown = false;
            for(int i = 0; i < s.length(); ++i){
                zigzag[curRow].append(s.charAt(i));
                if(curRow == numRows-1 || curRow == 0) isDown = !isDown;
                curRow += isDown ? 1 : -1;
            }
            StringBuilder answer = new StringBuilder();
            for(StringBuilder z : zigzag) answer.append(z);

            return answer.toString();
        }
    }
}
