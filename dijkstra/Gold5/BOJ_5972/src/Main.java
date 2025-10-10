import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

class Node implements Comparable<Node>{
    int end;
    int cost;
    Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node o){
        return cost-o.cost;
    }

}
public class Main {
    static int N,M;
    static int[] dist;
    static boolean[] visited;
    static int INF = 50000000;
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
    //농부 현서
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        visited = new boolean[N+1];

        graph = new ArrayList<>();
        for(int i = 0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i<=M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end,cost));
            graph.get(end).add(new Node(start,cost));
        }
       int answer =  dijkstra(1);

        System.out.println(answer);


    }

    private static int dijkstra(int i) {

        Arrays.fill(dist,INF);
        Arrays.fill(visited,false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[i] = 0;
        pq.offer(new Node(i,0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int cur = node.end;
            if(!visited[cur]){
                visited[cur] = true;
                for(Node no : graph.get(cur)){
                    if(!visited[no.end]){
                        if(dist[no.end] > dist[cur] + no.cost){
                            dist[no.end] = dist[cur] + no.cost;
                            pq.offer(new Node(no.end,dist[no.end]));
                        }
                    }
                }
            }

        }
        return dist[N];
    }
}