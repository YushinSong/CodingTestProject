package src.datastructure;

import java.util.*;

public class ProgrammersDeliveryAndCollection {
    class Solution {
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = 0;

            // 택배 가야할 집들의 index만 stack에 넣는다.
            Stack<Integer> deliverSt = new Stack<>();
            Stack<Integer> pickupSt = new Stack<>();
            for(int i = 0; i < n; ++i){
                if(deliveries[i] != 0) deliverSt.add(i);
                if(pickups[i] != 0) pickupSt.add(i);
            }

            int countDel = cap;
            int countPick = cap;
            // 배달 및 수거 stack이 둘 다 빌 때까지 반복
            while(!deliverSt.isEmpty() || !pickupSt.isEmpty()){
                // 어차피 트럭은 cap을 모두 채운 채 출발하는 게 가장 효율적이다.
                // 배달 및 수거를 가야 할 가장 먼거리만 알면, *2를 하면 한번 다녀온 거리가 될 것이다.
                if(deliverSt.isEmpty()) // 만약 배달갈 곳이 없다면, 수거할 거리 *2
                    answer += (pickupSt.peek() + 1) * 2;
                else if(pickupSt.isEmpty()) // 만약 수거갈 곳이 없다면, 배달할 거리 *2
                    answer += (deliverSt.peek() + 1) * 2;
                else // 배달하거나, 수거할 거리 중 더 먼 곳 *2
                    answer += (Math.max(deliverSt.peek(), pickupSt.peek()) + 1) * 2;

                // 거리를 구했으니, 이제 해당 회차에서 배달 및 수거 가능한 것은 stack에서 제외한다.
                popStack(cap, deliveries, deliverSt);
                popStack(cap, pickups, pickupSt);
            }

            return answer;
        }
        public void popStack(int cap, int[] houses, Stack<Integer> stack){
            while(cap > 0 && !stack.isEmpty()){
                int amount = houses[stack.peek()]; // 해당 집에서 배달/수거 해야할 양

                if(cap >= amount){ // 배달 및 수거가 가능한 경우
                    cap -= amount;
                    stack.pop(); // stack에서 제외한다.
                } else { // 배달 및 수거가 불가능한 경우, 가능한 만큼만 꺼내간다.
                    houses[stack.peek()] -= cap;
                    cap = 0;
                }
            }
        }
    }
}

// javascirpt
//function solution(cap, n, deliveries, pickups) {
//    var answer = 0;
//
//    // 택배 가야할 집들의 index만 array에 넣는다.
//    let deliverArray = [];
//    let pickupArray = [];
//    for(let i = 0; i < n; ++i){
//        deliveries[i] !== 0 && deliverArray.push(i);
//        pickups[i] !== 0 && pickupArray.push(i);
//    }
//
//    // 배달 및 수거 stack이 둘 다 빌 때까지 반복
//    while(deliverArray.length > 0 || pickupArray.length > 0){
//        // 어차피 트럭은 cap을 모두 채운 채 출발하는 게 가장 효율적이다.
//        // 배달 및 수거를 가야 할 가장 먼거리만 알면, *2를 하면 한번 다녀온 거리가 될 것이다.
//        if(deliverArray.length == 0) // 만약 배달갈 곳이 없다면, 수거할 거리 *2
//            answer += (pickupArray[pickupArray.length-1]+1)*2;
//        else if(pickupArray.length == 0) // 만약 수거갈 곳이 없다면, 배달할 거리 *2
//            answer += (deliverArray[deliverArray.length-1]+1)*2;
//        else // 배달하거나, 수거할 거리 중 더 먼 곳 *2
//            answer += (Math.max(deliverArray[deliverArray.length-1], pickupArray[pickupArray.length-1]) + 1) * 2;
//
//        // 거리를 구했으니, 이제 해당 회차에서 배달 및 수거 가능한 것은 stack에서 제외한다.
//        popIndexArray(cap, deliveries, deliverArray);
//        popIndexArray(cap, pickups, pickupArray);
//    }
//
//    return answer;
//}
//function popIndexArray(cap, houses, indexArray){
//    while(cap > 0 && indexArray.length > 0){
//        let peek = indexArray[indexArray.length-1];
//        let amount = houses[peek]; // 해당 집에서 배달/수거 해야할 양
//
//        if(cap >= amount){ // 배달 및 수거가 가능한 경우
//            cap -= amount;
//            indexArray.splice(indexArray.length-1, 1); // 배열에서 제외한다.
//        } else { // 배달 및 수거가 불가능한 경우, 가능한 만큼만 꺼내간다.
//            houses[peek] -= cap;
//            cap = 0;
//        }
//    }
//}



