package src.dfs;

import java.util.*;

public class ProgrammersChangeWord {
    class Solution {
        static int result;
        static boolean[] visit;

        public int solution(String begin, String target, String[] words) {
            visit = new boolean[words.length];

            dfs(begin, target, words, 0);

            return result;
        }

        static void dfs(String begin, String target, String[] words, int count){
            if(begin.equals(target)){
                result = count;
                return;
            }

            for(int i  = 0; i < words.length; i++){
                if(visit[i] == true)
                    continue;

                int notEqualCount = 0;
                for(int j = 0; j < begin.length(); ++j){
                    if(begin.charAt(j) != words[i].charAt(j))
                        ++notEqualCount;
                }

                if(notEqualCount == 1){
                    visit[i] = true;
                    dfs(words[i], target, words, count + 1);
                    visit[i] = false;
                }
            }
        }

    }
}
