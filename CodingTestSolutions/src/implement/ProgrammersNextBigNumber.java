package src.implement;

public class ProgrammersNextBigNumber {
    class Solution {
        public int solution(int n) {
            int nBinaryCount = BinaryOneCount(n);
            int answer = n;
            while(true){
                answer++;
                if(BinaryOneCount(answer) == nBinaryCount)
                    break;
            }
            return answer;
        }
        public int BinaryOneCount(int n){
            int answer = 0;
            String binary = Integer.toBinaryString(n);
            for(int i = 0; i < binary.length(); ++i)
                answer += binary.charAt(i)=='1' ? 1 : 0;
            return answer;
        }
    }
}
