package src.twopointer;

public class LeetCodeMovePiecestoObtainaString {
    class Solution {
        public boolean canChange(String start, String target) {
            int sPoint = 0; int tPoint = 0;
            int n = start.length();

            while(sPoint < n && tPoint < n){
                char curS = start.charAt(sPoint);
                char curT = target.charAt(tPoint);
                System.out.println(curS + " " + curT);
                if(curS == '_' || curT == '_'){
                    sPoint = curS == '_' ? sPoint+1 : sPoint;
                    tPoint = curT == '_' ? tPoint+1 : tPoint;
                } else if(curS == curT && ((curS=='L' && sPoint>=tPoint)||(curT=='R' && sPoint<=tPoint))){
                    sPoint++;
                    tPoint++;
                }else {
                    System.out.println("false");
                    return false;
                }
            }

            while(sPoint < n && start.charAt(sPoint) == '_')
                ++sPoint;
            while(tPoint < n && target.charAt(tPoint) == '_')
                ++tPoint;
            return sPoint == n && tPoint == n;
        }
    }
}
