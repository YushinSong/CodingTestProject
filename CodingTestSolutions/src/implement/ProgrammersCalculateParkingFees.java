package src.implement;

import java.util.*;

public class ProgrammersCalculateParkingFees {
    class Solution {
        public int[] solution(int[] fees, String[] records) {
            Map<String, Integer> carInRecords = new HashMap<>();
            Map<String, Integer> carTimeRecords = new TreeMap<>();
            for(String record : records){
                String[] recordSplit = record.split(" ");
                String[] timeSplit = recordSplit[0].split(":");
                int minutes = Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);

                if(recordSplit[2].equals("IN"))
                    carInRecords.put(recordSplit[1], minutes);
                else{
                    int totalTime = minutes - carInRecords.get(recordSplit[1]);

                    carTimeRecords.put(recordSplit[1], carTimeRecords.containsKey(recordSplit[1]) ? carTimeRecords.get(recordSplit[1]) + totalTime : totalTime);
                    carInRecords.remove(recordSplit[1]);
                }
            }
            for(String key : carInRecords.keySet()){
                int totalTime = (23 * 60 + 59) - carInRecords.get(key);
                carTimeRecords.put(key, carTimeRecords.containsKey(key) ? carTimeRecords.get(key) + totalTime : totalTime);
            }

            int[] answer = new int[carTimeRecords.size()];
            int index = 0;
            for(String key : carTimeRecords.keySet()){
                int minutes = carTimeRecords.get(key);
                if(fees[0] >= minutes)
                    answer[index] = fees[1];
                else{
                    int overCharge = (minutes - fees[0]) % fees[2] > 0 ? (minutes - fees[0]) / fees[2] + 1 : (minutes - fees[0]) / fees[2];
                    answer[index] = fees[1] + (overCharge * fees[3]);
                }
                index++;
            }

            return answer;
        }
    }
}
