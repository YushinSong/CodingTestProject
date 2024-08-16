package src.greedy;

import java.util.*;

public class ProgrammersLifeBoat {
    class Solution {
        public int solution(int[] people, int limit) {
            Arrays.sort(people);

            int answer = 0;
            int index = 0;
            for(int i = people.length-1; i >= index; i--){
                if(people[i] + people[index] <= limit){
                    answer++;
                    index++;
                }
                else answer++;
            }

            return answer;
        }
    }
}
