package src.math;

import java.util.*;

public class ProgrammersTheBestSet {
    class Solution {
        public int[] solution(int n, int s) {
            int[] answer = new int[n];

            if(s / n <= 0)
                return new int[]{-1};
            Arrays.fill(answer, s/n);
            int last = s % n;
            for(int i = 0; i < last; ++i)
                answer[answer.length-i-1]++;

            return answer;
        }
    }
}