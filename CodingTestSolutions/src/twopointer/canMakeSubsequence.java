package src.twopointer;

public class canMakeSubsequence {
    class Solution {
        public boolean canMakeSubsequence(String str1, String str2) {
            int str2Point = 0;
            for(int str1Point = 0; str1Point < str1.length() && str2Point < str2.length(); ++str1Point)
                str2Point = isMatch(str1.charAt(str1Point), str2.charAt(str2Point)) ?  str2Point+1 : str2Point;
            if(str2Point == str2.length()) return true;
            return false;
        }
        public boolean isMatch(char str1char, char str2char){
            if(str1char == str2char || str1char+1 == str2char) return true;
            if(str1char == 'z' && str2char == 'a') return true;
            return false;
        }
    }
}
