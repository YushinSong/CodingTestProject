package src.dfs;

public class ProgrammersVowelDictionary {
    class Solution {
        public String[] alpabets = new String[]{"A", "E", "I", "O", "U"};
        public int answer = 0;
        public int count = 0;
        public int solution(String word) {
            DFS(word, "");
            return answer;
        }
        public void DFS(String goal, String cur){
            if(goal.equals(cur)){
                answer = count;
                return;
            }
            if(cur.length() >= 5)
                return;

            for(String a : alpabets){
                count++;
                cur += a;
                DFS(goal, cur);
                cur = cur.substring(0, cur.length()-1);
            }
        }
    }
}
