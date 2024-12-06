package src.datastructure;

public class LeetCodeMaximumNumberofIntegerstoChooseFromaRangeI {
    import java.util.*;

    class Solution {
        public int maxCount(int[] banned, int n, int maxSum) {
            Set<Integer> banSet = new HashSet<>();
            for(int ban : banned)
                banSet.add(ban);

            int count = 0; int sum = 0;
            for(int i = 1; i <= n; ++i){
                if(banSet.contains(i)) continue;
                if(sum + i > maxSum) break;
                count++;
                sum += i;
            }

            return count;
        }
    }
}
