package src.twopointer;

public class LeetCodeIsSubsequence {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            if(s.equals("")) return true;
            int sIndex = 0;
            for(int tIndex = 0; tIndex < t.length(); ++tIndex){
                if(s.charAt(sIndex) == t.charAt(tIndex))
                    sIndex++;
                if(sIndex >= s.length()) break;
            }
            return sIndex == s.length();
        }
    }
}
