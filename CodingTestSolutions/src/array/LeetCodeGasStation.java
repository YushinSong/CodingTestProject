package src.array;

public class LeetCodeGasStation {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int gasCount = 0;
            int costCount = 0;
            for(int i = 0; i < gas.length; ++i){
                gasCount += gas[i];
                costCount += cost[i];
            }
            if(costCount > gasCount) return -1;

            int currentGas = 0;
            int startingIndex = 0;

            for(int i = 0; i < gas.length; ++i){
                currentGas += gas[i] - cost[i];
                if(currentGas < 0){
                    currentGas = 0;
                    startingIndex = i + 1;
                }
            }

            return startingIndex;
        }
    }
}
