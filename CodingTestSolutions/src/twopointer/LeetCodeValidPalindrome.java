package src.twopointer;

public class LeetCodeValidPalindrome {
    class Solution {
        public boolean isPalindrome(String s) {
            String letters = "";
            for(int i = 0; i < s.length(); ++i){
                if(Character.isLetterOrDigit(s.charAt(i)))
                    letters += s.charAt(i);
            }
            letters = letters.toLowerCase();
            int back = letters.length()-1;
            for(int front = 0; front < back; ++front){
                if(letters.charAt(front) != letters.charAt(back))
                    return false;
                back--;
            }

            return true;
        }
    }
}
