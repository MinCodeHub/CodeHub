import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer> graph[];
    static boolean[] visited;

    private static void bfs(int v) {

        Queue<Integer> que = new LinkedList<>();
        que.add(v);
        visited[v] = true;

        while(!que.isEmpty()){
            int node = que.poll();

            System.out.print(node+" ");

            for(int i = 0; i<graph[node].size(); i++){
                if(visited[graph[node].get(i)]){
                    continue;
                }
                que.add(graph[node].get(i));
                visited[graph[node].get(i)] = true;
            }
        }
    }

    private static void dfs(int v) {
            if(!visited[v]){
                System.out.print(v+" ");
                visited[v] = true;
            }

        for(int g : graph[v]){
            if(visited[g]){
                continue;
            }
            dfs(g);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i = 0; i< N + 1; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i =0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }
        for(int i = 0; i<N+1; i++){
            Collections.sort(graph[i]);
        }
        dfs(V);
        System.out.println();
        visited  = new boolean[N+1];

        bfs(V);

    }


}