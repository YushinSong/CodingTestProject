package src.greedy;

import java.util.*;

public class ProgrammersASurveillanceCamera {
    class Solution {
        public int solution(int[][] routes) {
            int answer = 1;

            Arrays.sort(routes, (o1, o2) -> {
                return o1[1] - o2[1];
            });
            int lastCamera = routes[0][1];
            for(int i = 1; i < routes.length; ++i){
                if(routes[i][0] > lastCamera){
                    answer++;
                    lastCamera = routes[i][1];
                }
            }

            return answer;
        }
    }
}
