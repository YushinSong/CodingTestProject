package src.datastructure;

import java.util.*;

public class ProgrammersSlicingRollcake {
    class Solution {
        public int solution(int[] topping) {
            int answer = 0;

            Map<Integer, Integer> chulsoo = new HashMap<>();
            Set<Integer> sister = new HashSet<>();

            for(int i = 0; i < topping.length; ++i)
                chulsoo.put(topping[i], chulsoo.getOrDefault(topping[i], 0)+1);

            for(int i = 0; i < topping.length; ++i){
                sister.add(topping[i]);
                chulsoo.put(topping[i], chulsoo.getOrDefault(topping[i], 0)-1);
                if(chulsoo.get(topping[i]) == 0)
                    chulsoo.remove(topping[i]);
                if(sister.size() == chulsoo.size())
                    answer++;
            }

            return answer;
        }
    }
}
