package src.math;

public class ProgrammersNumberExpression {
    class Solution {
        public int solution(int n) {
            int answer = 0;

            for(int i = 1; i <= n; ++i){
                int sum = 0;
                int num = i;
                while(sum < n){
                    sum += num;
                    num++;
                }
                if(sum == n)
                    answer++;
            }

            return answer;
        }
    }
}
