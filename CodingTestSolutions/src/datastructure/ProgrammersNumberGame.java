package src.datastructure;

import java.util.*;

public class ProgrammersNumberGame {
    class Solution {
        public int solution(int[] A, int[] B) {
            int answer = 0;

            Queue<Integer> aQ = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Integer> bQ = new PriorityQueue<>(Collections.reverseOrder());
            for(int i = 0; i < A.length; ++i){
                aQ.add(A[i]);
                bQ.add(B[i]);
            }
            while(!aQ.isEmpty()){
                int cur = aQ.poll();
                if(bQ.peek() > cur){
                    answer++;
                    bQ.poll();
                }
            }

            return answer;
        }
    }
}
