package src.math;

public class ProgrammersDiscriminantIntegerSquareRoot {
    class Solution {
        public long solution(long n) {
            double sqrt = Math.sqrt(n);
            if(sqrt % 1 > 0)
                return -1;
            else
                return (long)Math.pow(sqrt + 1, 2);
        }
    }
}
