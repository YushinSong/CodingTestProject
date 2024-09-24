package src.implement;

import java.util.*;

public class ProgrammersPCCP1BandageWrap {

    class Solution {
        public int solution(int[] bandage, int health, int[][] attacks) {
            int lastSecond = attacks[attacks.length-1][0];
            Map<Integer, Integer> attacksMap = new HashMap<>();
            for(int[] attack : attacks)
                attacksMap.put(attack[0], attack[1]);

            int curHealth = health;
            int skillTime = 0;
            for(int i = 0; i <= lastSecond; ++i){
                if(attacksMap.containsKey(i)){
                    curHealth -= attacksMap.get(i);
                    if(curHealth <= 0) return -1;
                    skillTime = 0;
                    continue;
                }

                curHealth += bandage[1];
                skillTime++;
                if(skillTime == bandage[0]){
                    curHealth += bandage[2];
                    skillTime = 0;
                }
                curHealth = Math.min(curHealth, health);
            }

            return curHealth;
        }
    }
}
