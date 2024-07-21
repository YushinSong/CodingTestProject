package src.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon1303 {

    private static int N;
    private static int M;
    private static String[][] map;
    private static boolean[][] visited;
    private static int W = 0;
    private static int B = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        M = Integer.parseInt(firstLine[1]);

        map = new String[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; ++i){
            String[] line = br.readLine().split("");
            for(int j = 0; j < N; ++j){
                map[i][j] = line[j];
            }
        }

        for(int i = 0; i < M; ++i){
            for(int j = 0; j < N; ++j){
                if(visited[i][j] == false)
                    bfs(i, j);
            }
        }

        System.out.printf(W + " " + B);

        br.close();
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static void bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true; // 방문

        double manCount = 1;

        String currentMan = map[x][y];

        while(!queue.isEmpty()){
            Node currentNode = queue.poll();

            for(int i = 0; i < dx.length; ++i){
                int nextX = currentNode.x + dx[i];
                int nextY = currentNode.y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N)// 맵의 크기를 벗어나는 경우 제외
                    continue;
                if(visited[nextX][nextY] == true || !map[nextX][nextY].equals(currentMan)) // 방문했거나, 아군인 아닌 경우 제외
                    continue;

                queue.add(new Node(nextX, nextY));
                visited[nextX][nextY] = true;
                manCount++;
            }
        }

        if(currentMan.equals("W"))
            W += Math.pow(manCount, 2);
        else
            B += Math.pow(manCount, 2);

    }

}

