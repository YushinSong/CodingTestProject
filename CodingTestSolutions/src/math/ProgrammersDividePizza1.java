package src.math;

public class ProgrammersDividePizza1 {
    class Solution {
        public int solution(int n) {
            return (n % 7) == 0 ? n / 7 : n / 7 +1;
        }
    }
}
