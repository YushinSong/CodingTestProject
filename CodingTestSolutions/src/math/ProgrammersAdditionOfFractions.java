package src.math;

public class ProgrammersAdditionOfFractions {
    class Solution {
        public int[] solution(int numer1, int denom1, int numer2, int denom2) {
            int numer = numer1*denom2 + numer2*denom1;
            int denom = denom1*denom2;

            int max = 1;
            for(int i = max; i <= numer && i <= denom; ++i){
                if(denom%i == 0 && numer%i == 0){
                    max = i;
                }
            }

            int[] answer = {numer/max, denom/max};
            return answer;
        }
    }
}
