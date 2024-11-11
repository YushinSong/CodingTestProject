package src.math;

public class ProgrammersBaseStationInstallation {
    class Solution {
        public int solution(int n, int[] stations, int w) {
            int answer = 0;
            int len = 1 + (w * 2);
            int lastEmptyPos = 1;

            for(int station : stations){
                int fGap = station - lastEmptyPos - w;
                lastEmptyPos = station + w + 1;
                if(fGap > 0)
                    answer += fGap%len==0 ? fGap/len : (fGap/len)+1;
            }
            int fGap = n - lastEmptyPos + 1;
            if(lastEmptyPos <= n)
                answer += fGap%len==0 ? fGap/len : (fGap/len)+1;

            return answer;
        }
    }
}
