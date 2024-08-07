package src.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Baekjoon2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] map = new boolean[101][101];
        int count = 0;
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; ++i){
            String[] readLine = br.readLine().split(" ");

            int inputX = Integer.parseInt(readLine[0]);
            int inputY = Integer.parseInt(readLine[1]);
            for(int x = inputX; x < inputX + 10; ++x) {
                for(int y = inputY; y < inputY + 10; ++y) {
                    if(map[x][y] != true){
                        map[x][y] = true;
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}
