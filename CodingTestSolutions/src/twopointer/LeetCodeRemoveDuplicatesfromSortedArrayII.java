package src.twopointer;

import java.util.*;

public class LeetCodeRemoveDuplicatesfromSortedArrayII {
    class Solution {
        public int removeDuplicates(int[] nums) {
            Map<Integer, Integer> countNum = new HashMap<>();
            int i = 0;
            for(int num : nums){
                countNum.put(num, countNum.getOrDefault(num, 0)+1);
                if(countNum.get(num) <= 2){
                    nums[i] = num;
                    i++;
                }
            }

            return i;
        }
    }
}
