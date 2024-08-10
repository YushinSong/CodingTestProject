package src.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        Map<Integer, Integer> numFreq = new TreeMap<>();
        int count = 0;
        for(int i = 0; i < N; ++i){
            int num = Integer.parseInt(br.readLine());
            numbers.add(num);
            count += num;

            if(numFreq.containsKey(num))    numFreq.put(num, numFreq.get(num) + 1);
            else                            numFreq.put(num, 1);
        }

        // 산술평균
        System.out.println(Math.round((float)count/N));

        // 중앙값
        Collections.sort(numbers);
        System.out.println(numbers.get(N/2));

        //  최빈값
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(numFreq.entrySet());
        entryList.sort((o1, o2) -> numFreq.get(o2.getKey()) - numFreq.get(o1.getKey()));
        int mostFreq = entryList.get(0).getValue();
        List<Integer> sameFreq = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : entryList){
            if(entry.getValue() != mostFreq) break;
            sameFreq.add(entry.getKey());
        }
        System.out.println(sameFreq.size()==1 ? sameFreq.get(0) : sameFreq.get(1));

        // 범위
        System.out.println(numbers.get(numbers.size() - 1) - numbers.get(0));


        br.close();
    }
}
