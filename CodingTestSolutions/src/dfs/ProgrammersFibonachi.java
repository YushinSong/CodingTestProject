package src.dfs;

public class ProgrammersFibonachi {
    class Solution {
        public int solution(int n) {
            return fibo(0, 1, 2, n);
        }
        public int fibo(int previous, int current, int index, int N){
            if(index == N) return (previous + current) % 1234567;
            return fibo(current % 1234567, (previous + current) % 1234567, index + 1, N);
        }
    }
}
