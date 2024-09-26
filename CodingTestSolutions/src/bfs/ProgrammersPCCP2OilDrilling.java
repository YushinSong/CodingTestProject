package src.bfs;

import java.util.*;

public class ProgrammersPCCP2OilDrilling {
    class Solution {
        public int solution(int[][] land) {
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};

            int r = land.length;
            int c = land[0].length;

            int[] cnt = new int[c];

            for(int i = 0; i < r; ++i){
                for(int j = 0; j < c; ++j){
                    if(land[i][j] == 0)
                        continue;

                    Set<Integer> line = new HashSet<>();
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.add(new int[]{i, j});
                    int area = 1;
                    line.add(j);

                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();

                        for(int z = 0; z < dx.length; ++z){
                            int nr = cur[0] + dx[z];
                            int nc = cur[1] + dy[z];

                            if(nr < 0 || nc < 0 || nr >= r || nc >= c)
                                continue;
                            if(land[nr][nc] == 0)
                                continue;

                            land[nr][nc] = 0;
                            line.add(nc);
                            area++;
                            queue.add(new int[]{nr, nc});
                        }
                    }
                    if(area != 1) area--;

                    for (int l : line) {
                        cnt[l] += area;
                    }
                }
            }

            int max = 0;
            for(int cn : cnt)
                max = Math.max(max, cn);

            return max;
        }
    }
}
