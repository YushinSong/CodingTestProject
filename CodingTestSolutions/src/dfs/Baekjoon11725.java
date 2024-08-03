package src.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon11725 {

    private static int[] parents;
    private static boolean[] isVisited;
    private static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        isVisited = new boolean[N + 1];
        parents = new int[N + 1];

        for(int i = 0; i < N + 1; ++i){
            List<Integer> newList = new ArrayList<>();
            list.add(newList);
        }
        for(int i = 0; i < N - 1; ++i){
            String[] readLine = br.readLine().split(" ");
            list.get(Integer.parseInt(readLine[0])).add(Integer.parseInt(readLine[1]));
            list.get(Integer.parseInt(readLine[1])).add(Integer.parseInt(readLine[0]));
        }

        dfs(1); // 트리의 루트가 1. 1부터 시작.

        for(int i = 2; i < parents.length; ++i)
            System.out.println(parents[i]);

        br.close();
    }

    private static void dfs(int index){
        isVisited[index] = true;
        for(int i : list.get(index)){
            if(!isVisited[i]) { // 방문하지 않은 노드라면
                parents[i] = index;
                dfs(i);
            }
        }
    }
}
