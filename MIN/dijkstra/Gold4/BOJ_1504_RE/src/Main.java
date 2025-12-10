import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int b;
    long c;

    Node(int b, long c) {
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(Node o) {
        return Long.compare(this.c,o.c);
    }
}

public class Main {
    static int N, E;
    static ArrayList<ArrayList<Node>> list;
    static long[] dist;
    static boolean[] visited;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dist = new long[N + 1];
        visited = new boolean[N + 1];

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            //양방향 그래프
            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));

        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        //꼭 거쳐야하는 정점 v1, v2
        // 가능한 두가지 순서 1 -> v1 -> v2
        // 1 -> v2 -> v1
        long ans1 = 0;
        long ans2 = 0;

        long d1 = dijkstra(1, v1);
        long d2 = dijkstra(v1, v2);
        long d3 = dijkstra(v2, N);


        long e1 = dijkstra(1, v2);
        long e2 = dijkstra(v2, v1);
        long e3 = dijkstra(v1, N);

        ans1 = (d1 >= INF || d2 >= INF || d3 >= INF) ? INF : d1 + d2 + d3;
        ans2 = (e1 >= INF || e2 >= INF || e3 >= INF) ? INF : e1 + e2 + e3;

        long ans = Math.min(ans1, ans2);
        if (ans == INF) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    static public long dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int cur = node.b;

            if (visited[cur]) {
                continue;
            }

            visited[cur] = true;

            for (Node no : list.get(cur)) {
                if (!visited[no.b] && dist[no.b] > dist[cur] + no.c) {
                    dist[no.b] = dist[cur] + no.c;
                    pq.offer(new Node(no.b, dist[no.b]));
                }
            }
        }


        return dist[end];
    }
}