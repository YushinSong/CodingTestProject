package src.datastructure;

import java.util.*;

public class ProgrammersOvertimeWorkIndex {
    class Solution {
        public long solution(int n, int[] works) {
            Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int work : works)
                pq.add(work);

            while(n != 0){
                if(pq.isEmpty())
                    return 0;
                int work = pq.poll() - 1;
                if(work > 0)
                    pq.add(work);
                n--;
            }

            long answer = 0;
            while(!pq.isEmpty()){
                int work = pq.poll();
                answer += work * work;
            }
            return answer;
        }
    }
}
