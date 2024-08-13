package src.datastructure;

import java.util.*;

public class ProgrammersIHateSameNumber {
    public class Solution {
        public Stack<Integer> solution(int []arr) {
            int[] answer = {};

            Stack<Integer> st = new Stack<>();
            for(int a : arr){
                if(st.isEmpty()){
                    st.push(a);
                    continue;
                }
                if(st.peek() != a)
                    st.push(a);
            }

            return st;
        }
    }
}
