package src.sort;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(int[] numbers) {
        List<String> numberList = new ArrayList<>();
        for(int i = 0; i < numbers.length; ++i)
            numberList.add(String.valueOf(numbers[i]));

        Collections.sort(numberList, (a, b) -> (b + a).compareTo(a + b));

        if(numberList.get(0).equals("0"))
            return "0";

        return String.join("", numberList);
    }
}

