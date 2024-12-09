package src.math;

public class LeetCodePalindromeNumber {
    class Solution {
        public boolean isPalindrome(int x) {
            if(x < 0) return false;
            if(x == 0) return true;
            int temp = x; String rs = "";
            while(temp > 0){
                rs += Integer.valueOf(temp % 10);
                temp /= 10;
            }

            return x == Long.parseLong(rs);
        }
    }
}
