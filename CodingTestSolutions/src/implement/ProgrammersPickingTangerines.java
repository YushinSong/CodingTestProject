package src.implement;

import java.util.*;

public class ProgrammersPickingTangerines {
    class Solution {
        public int solution(int k, int[] tangerine) {
            int answer = 0;
            Arrays.sort(tangerine);
            int[] tans = new int[tangerine[tangerine.length-1]];
            for(int tan : tangerine)
                tans[tan-1]++;
            Arrays.sort(tans);

            for(int i = tans.length-1; i >= 0; --i){
                k -= tans[i];
                answer++;
                if(k <= 0)
                    break;
            }

            return answer;
        }
    }
}
