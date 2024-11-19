package src.datastructure;

import java.util.*;

public class ProgrammersMakingHamburger {
    class Solution {
        public int solution(int[] ingredient) {
            int answer = 0;

            Stack<Integer> st = new Stack<>();
            for(int ing : ingredient){
                st.add(ing);
                if(st.size() >= 4){
                    if(st.get(st.size()-4) == 1
                            && st.get(st.size()-3) == 2
                            && st.get(st.size()-2) == 3
                            && st.get(st.size()-1) == 1){
                        answer++;
                        st.pop(); st.pop(); st.pop(); st.pop();
                    }
                }
            }

            return answer;
        }
    }
}
