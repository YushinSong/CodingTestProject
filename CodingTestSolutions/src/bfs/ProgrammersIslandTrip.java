package src.bfs;

import java.util.*;

public class ProgrammersIslandTrip {
    class Solution {
        public int[] solution(String[] maps) {
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            int row = maps.length;
            int col = maps[0].length();
            List<Integer> resultList = new ArrayList<>();

            for(int i = 0; i < row; ++i){
                for(int j = 0; j < col; ++j){
                    if(maps[i].charAt(j) == 'X') continue;

                    Queue<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i, j});
                    int area = Integer.parseInt(maps[i].substring(j, j+1));
                    maps[i] = maps[i].substring(0, j) + "X" + maps[i].substring(j + 1);
                    while(!q.isEmpty()){
                        int[] cur = q.poll();

                        for(int z = 0; z < dx.length; ++z){
                            int nr = cur[0] + dx[z];
                            int nc = cur[1] + dy[z];

                            if(nr<0 || nr>=row || nc<0 || nc>=col)
                                continue;
                            if(maps[nr].charAt(nc) == 'X')
                                continue;

                            q.add(new int[]{nr, nc});
                            area += Integer.parseInt(maps[nr].substring(nc, nc+1));
                            maps[nr] = maps[nr].substring(0, nc) + "X" + maps[nr].substring(nc + 1);
                        }
                    }
                    resultList.add(area);
                }
            }

            if(resultList.size() == 0)
                return new int[]{-1};

            int[] answer = new int[resultList.size()];
            Collections.sort(resultList);
            for(int i = 0; i < resultList.size(); ++i)
                answer[i] = resultList.get(i);

            return answer;
        }
    }
}
