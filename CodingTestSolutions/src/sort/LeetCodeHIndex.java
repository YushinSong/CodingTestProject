package src.sort;

import java.util.Arrays;

public class LeetCodeHIndex {
    class Solution {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int size = citations.length;
            for(int i = 0; i < size; ++i){
                if(citations[i] >= size - i)
                    return size - i;
            }

            return 0;
        }
    }
}
