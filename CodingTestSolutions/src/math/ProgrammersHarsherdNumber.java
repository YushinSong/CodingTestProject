package src.math;

public class ProgrammersHarsherdNumber {
    class Solution {
        public boolean solution(int x) {
            int tempX = x;
            int sum = 0;
            while(tempX > 0){
                sum += tempX % 10;
                tempX /= 10;
            }

            return x % sum == 0;
        }
    }
}
