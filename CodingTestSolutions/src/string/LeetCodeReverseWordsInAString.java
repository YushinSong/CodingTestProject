package src.string;

public class LeetCodeReverseWordsInAString {
    class Solution {
        public String reverseWords(String s) {
            String answer = "";
            for(String word : s.split(" ")){
                if(word.equals("")) continue;
                answer = word + " " + answer;
            }
            return answer.trim();
        }
    }
}
