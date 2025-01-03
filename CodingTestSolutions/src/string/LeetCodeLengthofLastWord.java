package src.string;

public class LeetCodeLengthofLastWord {
    class Solution {
        public int lengthOfLastWord(String s) {
            String[] split = s.trim().split(" ");
            return split[split.length-1].length();
        }
    }
}
