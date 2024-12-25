package src.array;

import java.util.HashMap;
import java.util.Map;

public class LeetCodeRomanToInteger {
    class Solution {
        public int romanToInt(String s) {
            Map<Character, Integer> romanMap = new HashMap<>();
            romanMap.put('M', 1000);
            romanMap.put('D', 500);
            romanMap.put('C', 100);
            romanMap.put('L', 50);
            romanMap.put('X', 10);
            romanMap.put('V', 5);
            romanMap.put('I', 1);

            int answer = romanMap.get(s.charAt(s.length()-1));
            char beforeChar = s.charAt(s.length()-1);
            for(int i = s.length()-2; i >= 0; --i){
                answer += romanMap.get(beforeChar) > romanMap.get(s.charAt(i)) ? -romanMap.get(s.charAt(i)) : romanMap.get(s.charAt(i));
                beforeChar = s.charAt(i);
            }

            return answer;
        }
    }
}
