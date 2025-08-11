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
    static boolean[] visited;
    static int cnt;
    static  ArrayList<Integer> graph[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];

        graph = new ArrayList[N+1];
        for(int i =0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i<M;i++){
         st = new StringTokenizer(br.readLine());
         int v1 = Integer.parseInt(st.nextToken());
         int v2 = Integer.parseInt(st.nextToken());

         graph[v1].add(v2);
         graph[v2].add(v1);
        }
        cnt= 0;
        bfs(1);
      System.out.println(cnt);
    }

    private static void bfs(int i) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visited[i] = true;

        while(!q.isEmpty()){
            int n = q.poll();

            for(int j =0; j<graph[n].size(); j++){
                if(!visited[graph[n].get(j)]){ //아직 방문을 안했다면
                    cnt++;
                    q.offer(graph[n].get(j));
                    visited[graph[n].get(j)] = true;
                }
            }

        }
    }
}