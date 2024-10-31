package src.bfs;

import java.io.*;
import java.util.*;

public class SofteerWayToAndFromWork {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]); int m = Integer.parseInt(firstLine[1]);

        List<Integer>[] nodes = new ArrayList[n];
        List<Integer>[] nodesReverse = new ArrayList[n];
        for(int i = 0; i < n; ++i){
            nodes[i] = new ArrayList<>();
            nodesReverse[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; ++i){
            String[] tempLine = br.readLine().split(" ");
            nodes[Integer.parseInt(tempLine[0])-1].add(Integer.parseInt(tempLine[1])-1);
            nodesReverse[Integer.parseInt(tempLine[1])-1].add(Integer.parseInt(tempLine[0])-1);
        }
        String[] lastLine = br.readLine().split(" ");
        int S = Integer.parseInt(lastLine[0]); int T = Integer.parseInt(lastLine[1]);
        // 입력 완료

        boolean[] StoT = new boolean[n]; StoT[S-1] = true; StoT[T-1] = true;
        boolean[] TtoS = new boolean[n]; TtoS[S-1] = true; TtoS[T-1] = true;
        boolean[] StoTReverse = new boolean[n];
        boolean[] TtoSReverse = new boolean[n];
        StoT = visitNodesBFS(nodes, StoT, S, T);
        TtoS = visitNodesBFS(nodes, TtoS, T, S);
        StoTReverse = visitNodesBFS(nodesReverse, StoTReverse, S, T);
        TtoSReverse = visitNodesBFS(nodesReverse, TtoSReverse, T, S);

        int answer = 0;
        for(int i = 0; i < n; ++i){
            if(i == S-1 || i == T-1)
                continue;
            if(StoT[i] && TtoS[i] && StoTReverse[i] && TtoSReverse[i])
                answer++;
        }
        System.out.println(answer);

        br.close();
    }
    public static boolean[] visitNodesBFS(List<Integer>[] nodes, boolean[] visited, int start, int end){
        boolean[] answer = visited;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start - 1);

        while(!queue.isEmpty()){
            int currentNode = queue.poll();

            for(int linkednode : nodes[currentNode]){
                if(!answer[linkednode]){
                    queue.add(linkednode);
                    answer[linkednode] = true;
                }
            }
        }

        return answer;
    }
}