package src.bfs;

import java.util.*;

public class ProgrammersGameMapShortcut {
    class Solution {
        public int solution(int[][] maps) {
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};

            int n = maps.length;
            int m = maps[0].length;

            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[]{0, 0});
            while(!q.isEmpty()){
                int[] cur = q.poll();

                for(int i = 0; i < dx.length; ++i){
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                        continue;
                    if(maps[nx][ny] != 1)
                        continue;

                    q.add(new int[]{nx, ny});
                    maps[nx][ny] = maps[cur[0]][cur[1]] + 1;
                    if(nx == n - 1 && ny == m - 1)
                        return maps[nx][ny];
                }
            }

            return -1;
        }
    }
}
