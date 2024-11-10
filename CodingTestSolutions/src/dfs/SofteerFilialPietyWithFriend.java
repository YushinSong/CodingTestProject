package src.dfs;

import java.io.*;
import java.util.*;

public class SofteerFilialPietyWithFriend {
    public class Main {
        public static int n, m;
        public static int[] dirX = {-1, 0, 0, 1};
        public static int[] dirY = {0, 1, -1, 0};
        public static int[][] map;
        public static int[][] friends;
        public static boolean[][] visited;
        public static int answer = 0;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] firstLine = br.readLine().split(" ");
            n = Integer.parseInt(firstLine[0]); m = Integer.parseInt(firstLine[1]);
            map = new int[n][n];
            visited = new boolean[n][n];
            friends = new int[m][2];
            for(int i = 0; i < n; ++i){
                String[] tempLine = br.readLine().split(" ");
                for(int j = 0; j < n; ++j){
                    map[i][j] = Integer.parseInt(tempLine[j]);
                }
            }
            for(int i = 0; i < m; ++i){
                String[] tempLine = br.readLine().split(" ");
                friends[i][0] = Integer.parseInt(tempLine[0])-1;
                friends[i][1] = Integer.parseInt(tempLine[1])-1;
                visited[friends[i][0]][friends[i][1]] = true;
                answer += map[friends[i][0]][friends[i][1]];
            }

            DFS(friends[0][0], friends[0][1], 0, 0, answer);
            System.out.println(answer);

            br.close();
        }
        public static void DFS(int x, int y, int fNum, int seconds, int sum){
            answer = Math.max(answer, sum);

            if(seconds == 3){  // 해당 친구의 3초 끝
                if(fNum == m-1)
                    return;
                DFS(friends[fNum+1][0], friends[fNum+1][1], fNum+1, 0, sum); // 다음 친구 루트 찾기 시작
            } else {
                for(int i = 0; i < 4; ++i){
                    int nextX = x + dirX[i];
                    int nextY = y + dirY[i];
                    if(nextX < 0 || nextX > n-1 || nextY < 0 || nextY > n-1 || visited[nextX][nextY])
                        continue;

                    visited[nextX][nextY] = true;
                    DFS(nextX, nextY, fNum, seconds+1, sum+map[nextX][nextY]);
                    visited[nextX][nextY] = false;
                }
            }
        }
    }

}
