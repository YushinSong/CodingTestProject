package src.string;

public class ProgrammersDivideString {
    class Solution {
        private int countDivide = 0;
        public int solution(String s) {
            countNum(s);

            return countDivide;
        }
        public void countNum(String s){
            int index = 1;
            int sameCount = 1;
            int diffCount = 0;
            while(sameCount != diffCount){
                if(s.length() - 1 <= index){
                    countDivide++;
                    return;
                }

                if(s.charAt(0) == s.charAt(index))
                    sameCount++;
                else
                    diffCount++;
                index++;
            }
            countDivide++;
            countNum(s.substring(index, s.length()));
        }
    }
}
