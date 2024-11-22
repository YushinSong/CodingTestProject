package src.implement;

public class ProgrammersNumberAndAdditionOfDivisors {
    class Solution {
        public int solution(int left, int right) {
            int answer = 0;
            for(int i = left; i <= right; ++i){
                answer = isEven(i) ? answer + i : answer - i;
            }
            return answer;
        }
        public boolean isEven(int num){
            int divideCount = 0;
            for(int i = 1; i <= num; ++i)
                if(num % i == 0) divideCount++;
            if(divideCount % 2 == 0) return true;
            else return false;
        }
    }
}
