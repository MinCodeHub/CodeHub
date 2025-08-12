import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static ArrayList<Integer> [] graph;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        result = 0;

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
           st = new StringTokenizer(br.readLine());
           int v1 = Integer.parseInt(st.nextToken());
           int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);

        }
        for(int i = 1; i <N+1; i++){
            if(!visited[i]){
                q.offer(i);
                bfs();
                result++;
            }
        }
        System.out.println(result);

    }

    private static void bfs() {
        while(!q.isEmpty()){
            int v = q.poll();
            visited[v] = true;

            for(int g : graph[v]){
                if(!visited[g]){
                    q.offer(g);
                    visited[g] = true;
                }
            }
        }
    }
}