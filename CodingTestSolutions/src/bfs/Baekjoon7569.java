package src.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon7569 {
    private static int M, N, H;
    private static int[][][] box;
    private static Queue<Location> queue = new LinkedList<>();

    static class Location {
        public int x;
        public int y;
        public int z;

        public Location(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        M = Integer.parseInt(firstLine[0]);
        N = Integer.parseInt(firstLine[1]);
        H = Integer.parseInt(firstLine[2]);
        box = new int[H][N][M];

        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                String[] inputLine = br.readLine().split(" ");
                for (int x = 0; x < M; x++) {
                    box[z][y][x] = Integer.parseInt(inputLine[x]);
                    if (box[z][y][x] == 1) {
                        queue.add(new Location(x, y, z));
                    }
                }
            }
        }

        System.out.println(bfs());

        br.close();
    }

    private static int bfs() {
        int xArr[] = {0, 1, 0, -1, 0, 0};
        int yArr[] = {-1, 0, 1, 0, 0, 0};
        int zArr[] = {0, 0, 0, 0, 1, -1};

        while(!queue.isEmpty()){
            Location currentNode = queue.poll();

            for(int i = 0 ; i < xArr.length; i++) { // 위 아래 왼쪽 오른쪽 앞 뒤
                int newX = currentNode.x + xArr[i];
                int newY = currentNode.y + yArr[i];
                int newZ = currentNode.z + zArr[i];
                if(checkIsSpreadable(newX, newY, newZ)){
                    queue.add(new Location(newX, newY, newZ));
                    // 노드 방문 처리 and 노드까지 도달하는데 걸린 count++
                    box[newZ][newY][newX] = box[currentNode.z][currentNode.y][currentNode.x] + 1;
                }
            }
        }

        int maxNumber = Integer.MIN_VALUE;
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if(box[z][y][x] == 0) // 익지 않은 토마토가 있다면 -1반환
                        return -1;
                    maxNumber = Math.max(maxNumber, box[z][y][x]);
                }
            }
        }

        if(maxNumber == 1) // 최대값이 1이라면, 원래부터 모두 익어있었다는 뜻이다. 0반환
            return 0;
        return maxNumber - 1;
    }

    private static boolean checkIsSpreadable(int x, int y, int z) {
        if(x < 0 || x >= M || y < 0 || y >= N || z < 0 || z >= H)
            return false;
        if(box[z][y][x] == 0)
            return true;
        return false;
    }
}
