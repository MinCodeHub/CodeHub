import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int v;
    int w;

    Node(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}

public class Main {

    static int V, K;
    static int start;
    static List<ArrayList<Node>> list = new ArrayList<>();
    static int[] dist;
    static int[] res;
    static boolean[] visited;

    static int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[V+1];
        visited = new boolean[V+1];
        res = new int[V+1];
        Arrays.fill(res,INF);

        //초기화
        list = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        start = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(u).add(new Node(v, w));
        }

        dijkstra(start);

        for (int i = 1; i <= V; i++) {
            System.out.println(dist[i] == INF ? "INF" : dist[i]);
        }
    }

    private static void dijkstra(int start) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));


        while(!pq.isEmpty()) {

            Node node = pq.poll();
            int cur = node.v;

            if(!visited[cur]){
                visited[cur] = true;

                for(Node n: list.get(cur)){
                   if(!visited[n.v] && dist[n.v] > dist[cur] + n.w){
                       dist[n.v] = dist[cur] + n.w;
                       pq.offer(new Node(n.v, dist[n.v]));
                   }
                }
            }
        }
    }
}