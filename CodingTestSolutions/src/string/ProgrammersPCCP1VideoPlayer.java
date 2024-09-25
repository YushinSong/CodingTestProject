package src.string;

import java.util.stream.*;
import java.util.*;

public class ProgrammersPCCP1VideoPlayer {
    class Solution {
        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            String[] video_lenSp = video_len.split(":");
            String[] posSp = pos.split(":");
            String[] op_startSp = op_start.split(":");
            String[] op_endSp = op_end.split(":");
            int video_lenS = Integer.parseInt(video_lenSp[0]) * 60 + Integer.parseInt(video_lenSp[1]);
            int posS = Integer.parseInt(posSp[0]) * 60 + Integer.parseInt(posSp[1]);
            int op_startS = Integer.parseInt(op_startSp[0]) * 60 + Integer.parseInt(op_startSp[1]);
            int op_endS = Integer.parseInt(op_endSp[0]) * 60 + Integer.parseInt(op_endSp[1]);

            if(checkInOpening(posS, op_startS, op_endS))
                posS = op_endS;
            for(int i = 0; i < commands.length; ++i){
                if(commands[i].equals("next")){
                    posS += 10;
                    posS = Math.min(posS, video_lenS);
                }
                else{
                    posS -= 10;
                    posS = Math.max(posS, 0);
                }
                if(checkInOpening(posS, op_startS, op_endS))
                    posS = op_endS;
            }

            return (posS / 60 < 10 ? "0" : "") + String.valueOf(posS / 60) + ":"
                    + (posS % 60 < 10 ? "0" : "") + String.valueOf(posS % 60);
        }
        public boolean checkInOpening(int cur, int opS, int opE){
            if(opS <= cur && cur <= opE)
                return true;
            return false;
        }
    }
}
