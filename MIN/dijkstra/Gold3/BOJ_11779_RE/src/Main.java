import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Node implements Comparable<Node> {
    int end;
    int cost;

    Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }

}

public class Main {
    static int n, m;
    static int start;
    static int end;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;
    static int INF = Integer.MAX_VALUE / 2;
    static int[] prev;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        prev = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(s).add(new Node(e, c));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));

        ArrayList<Integer> path = new ArrayList<>();
        int cur = end;
        path.add(cur);

        int cnt = 1;

        while (cur != start) {
            path.add(prev[cur]);
            cur = prev[cur];
            cnt++;
        }
        System.out.println(cnt);
        StringBuilder sb = new StringBuilder();

        Collections.reverse(path);
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i)).append(" ");
        }
        System.out.println(sb);

    }

    static public int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);
        Arrays.fill(prev, -1);


        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cur = node.end;
            if (visited[cur]) {
                continue;
            }
            visited[node.end] = true;
            for (Node no : list.get(cur)) {
                if (!visited[no.end] && dist[no.end] > dist[cur] + no.cost) {
                    dist[no.end] = dist[cur] + no.cost;
                    prev[no.end] = cur;
                    pq.offer(new Node(no.end, dist[no.end]));
                }
            }
        }


        return dist[end];
    }

}