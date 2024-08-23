package src.string;

public class ProgrammersPYCountOfString {
    class Solution {
        boolean solution(String s) {
            int pCount = 0;
            int yCount = 0;
            for(String c : s.split("")){
                pCount = c.toUpperCase().equals("P") ? pCount + 1 : pCount;
                yCount = c.toUpperCase().equals("Y") ? yCount + 1 : yCount;
            }

            return pCount == yCount;
        }
    }
}
