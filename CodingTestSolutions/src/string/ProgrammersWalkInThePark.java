package src.string;

import java.util.Arrays;

public class ProgrammersWalkInThePark {
    public static int[] main(String[] args, String[] park, String[] routes) {
        int[] answer = new int[2];

        int col = park.length; int row = park[0].length();
        String entire = String.join("", Arrays.asList(park));
        int nowSX = entire.indexOf("S") % col;
        int nowSY = entire.indexOf("S") / row;

        for(String route : routes){
            int move = Integer.parseInt(route.split(" ")[1]);
            int currentPos = nowSX + (row * nowSY);
            switch(route.split(" ")[0]){
                case "N":
                    if(nowSY - move >= 0){
                        String testX = "";
                        for(int i = 1; i <= move; ++i)
                            testX += entire.charAt(currentPos - (row * i));
                        if(!testX.contains("X"))
                            nowSY -= move;
                    }
                    break;
                case "S":
                    if(nowSY + move < col){
                        String testX = "";
                        for(int i = 1; i <= move; ++i)
                            testX += entire.charAt(currentPos + (row * i));
                        if(!testX.contains("X"))
                            nowSY += move;
                    }
                    break;
                case "W":
                    if(nowSX - move >= 0 && !entire.substring(currentPos - move, currentPos).contains("X"))
                        nowSX -= move;
                    break;
                case "E":
                    if(nowSX + move < row && !entire.substring(currentPos + 1, currentPos + move + 1).contains("X"))
                        nowSX += move;
                    break;
            }
        }

        answer[0] = nowSY; answer[1] = nowSX;

        return answer;
    }
}
