package src.datastructure;

import java.util.*;

public class LeetCodeInsertDeleteGetRandomO1 {
    class RandomizedSet {
        private List<Integer> listVal;
        private Map<Integer, Boolean> mapVal;

        public RandomizedSet() {
            listVal = new ArrayList<>();
            mapVal = new HashMap<>();
        }

        public boolean insert(int val) {
            if(mapVal.containsKey(val)) return false;

            listVal.add(val);
            mapVal.put(val, true);
            return true;
        }

        public boolean remove(int val) {
            if(!mapVal.containsKey(val)) return false;

            listVal.remove(listVal.indexOf(val));
            mapVal.remove(val);
            return true;
        }

        public int getRandom() {
            Random random = new Random();
            return listVal.get(random.nextInt(listVal.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
