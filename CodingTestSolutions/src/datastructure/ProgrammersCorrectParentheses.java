package src.datastructure;

import java.util.*;

public class ProgrammersCorrectParentheses {
    class Solution {
        boolean solution(String s) {
            Stack<Character> sStack = new Stack<>();

            for(int i = 0; i < s.length(); ++i){
                if(s.charAt(i) == '(')
                    sStack.push(s.charAt(i));
                else{
                    if(sStack.isEmpty())
                        return false;
                    sStack.pop();
                }
            }

            if(!sStack.isEmpty())
                return false;
            return true;
        }
    }
}
