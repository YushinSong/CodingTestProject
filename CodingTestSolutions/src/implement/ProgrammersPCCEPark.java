package src.implement;

import java.util.*;

public class ProgrammersPCCEPark {
    class Solution {
        public int solution(int[] mats, String[][] park) {
            Arrays.sort(mats);
            for(int index = mats.length - 1; index >= 0; --index){
                int mat = mats[index];
                for(int i = 0; i <= park.length - mat; ++i){
                    for(int j = 0; j <= park[i].length - mat; ++j){
                        if(checkArea(park, mat, i, j))
                            return mat;
                    }
                }
            }

            return -1;
        }
        public boolean checkArea(String[][] park, int mat, int y, int x){
            for(int i = y; i < y + mat; ++i){
                for(int j = x; j < x + mat; ++j){
                    if(!park[i][j].equals("-1"))
                        return false;
                }
            }

            return true;
        }
    }
}
