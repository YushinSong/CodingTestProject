package src.implement;

import java.util.*;

public class ProgrammersTurnNumbersUpsideDownToMakeArray {
    class Solution {
        public List<Integer> solution(long n) {
            List<Integer> answer = new ArrayList<>();

            while(n > 0){
                answer.add((int)(n % 10));
                n /= 10;
            }

            return answer;
        }
    }
}
