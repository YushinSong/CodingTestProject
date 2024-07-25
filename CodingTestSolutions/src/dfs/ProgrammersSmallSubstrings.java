package src.dfs;

public class ProgrammersSmallSubstrings {
    class Solution {
        public int solution(String t, String p) {
            return logic(t, p, 0, 0);
        }
        public static int logic(String t, String p, int tIndex, int count){
            if(tIndex + p.length() > t.length())
                return count;

            if(Long.parseLong(t.substring(tIndex, tIndex+p.length())) <= Long.parseLong(p))
                count++;

            return logic(t, p, tIndex + 1, count);
        }
    }
}
