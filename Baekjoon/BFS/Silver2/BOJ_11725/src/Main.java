import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] visited;
    static int[] parentmap;
    static Queue<Integer> q = new LinkedList<>();
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        visited = new boolean[N+1];
        parentmap = new int[N+1];

        graph = new ArrayList[N+1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1 ; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        q.offer(1);
        visited[1] = true;
        bfs();

        for(int i=2; i<=N; i++){
            System.out.println(parentmap[i]);
        }
    }

    private static void bfs() {

        while(!q.isEmpty()){
            int parent = q.poll();
            for(int g: graph[parent]){
                if(!visited[g]){
                    parentmap[g]= parent;
                    visited[g] = true;
                    q.offer(g);
                }

            }
        }
    }
}