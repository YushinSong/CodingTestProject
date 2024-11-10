package src.datastructure;

import java.util.*;

public class ProgrammersEnglishWordChainGame {
    class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = new int[]{0, 0};
            Set<String> remember = new HashSet<>();

            int index;
            int turn = 0;
            char lastChar = words[0].charAt(0);
            for(index = 0; index < words.length; ++index){
                if(remember.contains(words[index]) || words[index].charAt(0) != lastChar){
                    answer[0] = turn+1;
                    answer[1] = ((index + 1)%n)>0 ? ((index+1)/n)+1 : (index+1)/n;
                    break;
                }
                remember.add(words[index]);
                lastChar = words[index].charAt(words[index].length()-1);
                turn = turn==n-1 ? 0 : turn+1;
            }

            return answer;
        }
    }
}
