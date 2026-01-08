import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Node implements Comparable<Node> {
    int end;
    int cost;

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    //낮은 비용부터 정렬
    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int N, M, X;
    static int[] dist;
    static boolean[] visited;
    static int INF = 1000000;
    static List<ArrayList<Node>> list;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        visited = new boolean[N + 1];

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(s).add(new Node(e, c));
        }

        for (int i = 1; i <= N; i++) {
            int res1 = 0;

            res1 += dijkstra(i, X);
            res1 += dijkstra(X, i);
            result = Math.max(res1, result);
        }
        System.out.println(result);
    }

    private static int dijkstra(int start, int end) {

        Arrays.fill(visited, false);
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node no = pq.poll();
            int cur = no.end;
            visited[cur] = true;

            for (Node node : list.get(cur)) {
                if (!visited[node.end] && dist[node.end] > dist[cur] + node.cost) {
                    dist[node.end] = dist[cur] + node.cost;
                    pq.offer(new Node(node.end, dist[node.end]));
                }
            }
        }
        return dist[end];


    }

}