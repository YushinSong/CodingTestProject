package src.implement;

import java.util.*;
import java.time.*;

public class ProgrammersExpirationDateOfPersonalInfo {
    class Solution {
        public List<Integer> solution(String today, String[] terms, String[] privacies) {
            List<Integer> answer = new ArrayList<>();

            String[] todaySplit = today.split("\\.");
            LocalDate todayDate = LocalDate.of(Integer.parseInt(todaySplit[0]), Integer.parseInt(todaySplit[1]), Integer.parseInt(todaySplit[2]));
            Map<String, Integer> dateMap = new HashMap<>();
            for(String term : terms){
                String[] temp = term.split(" ");
                dateMap.put(temp[0], Integer.parseInt(temp[1]));
            }

            for(int i = 0; i < privacies.length; ++i){
                String[] privaciyTemp = privacies[i].split(" ");
                String[] dateSplit = privaciyTemp[0].split("\\.");
                int year = Integer.parseInt(dateSplit[0]);
                int month = Integer.parseInt(dateSplit[1]);
                int day = Integer.parseInt(dateSplit[2]) - 1;

                if(day == 0){
                    day = 28;
                    month--;
                    if(month == 0){
                        month = 12;
                        year--;
                    }
                }

                month += dateMap.get(privaciyTemp[1]);
                System.out.println(year + "." + month + "." + day);
                year += month / 12 > 0 ? (month % 12 == 0 ? month / 12 - 1 : month / 12) : 0;
                month = month % 12 == 0 ? 12 : month % 12;
                LocalDate tempDate = LocalDate.of(year, month, day);
                if(todayDate.isAfter(tempDate)){
                    answer.add(i + 1);
                }
            }

            return answer;
        }
    }
}
