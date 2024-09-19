package src.datastructure;

import java.util.*;

public class ProgrammersParenthesisRotate {
    class Solution {
        public int solution(String s) {
            int answer = 0;

            for(int i = 0; i < s.length(); ++i){
                answer += check(s) ? 1 : 0;
                s = s.substring(1) + s.charAt(0);
            }

            return answer;
        }
        public boolean check(String shiftS){
            Stack<Character> charStack = new Stack<>();

            for(int i = 0; i < shiftS.length(); ++i){
                char cur = shiftS.charAt(i);
                if(cur == '[' || cur == '(' || cur == '{')
                    charStack.push(cur);
                else{
                    if(charStack.isEmpty())
                        return false;
                    char peek = charStack.peek();
                    if((cur == ']' && peek == '[') || (cur == ')' && peek == '(') || (cur == '}' && peek == '{'))
                        charStack.pop();
                    else
                        return false;
                }
            }
            if(!charStack.isEmpty())
                return false;

            return true;
        }
    }
}
