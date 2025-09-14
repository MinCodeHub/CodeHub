import java.io.*;
import java.util.*;

/**
 * BOJ 11407 - 책 구매하기 3
 * 최소비용최대유량(MCMF, SPFA)
 */
public class Main {
    //to : 간선 도착 정점

    static class Edge {
        int to, rev, cap;
        int cost;
        Edge(int to, int rev, int cap, int cost) {
            this.to = to; this.rev = rev; this.cap = cap; this.cost = cost;
        }
    }

    static class MinCostMaxFlow {
        final int N;
        List<Edge>[] g;

        MinCostMaxFlow(int n) {
            N = n;
            g = new ArrayList[n];
            for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        }

        void addEdge(int u, int v, int cap, int cost) {
            Edge a = new Edge(v, g[v].size(), cap, cost);
            Edge b = new Edge(u, g[u].size(), 0, -cost);
            g[u].add(a);
            g[v].add(b);
        }

        // returns [maxFlow, minCost]
        long[] minCostMaxFlow(int s, int t) {
            long flow = 0, cost = 0;
            long INF = Long.MAX_VALUE / 4;

            int[] inq = new int[N];
            long[] dist = new long[N];
            int[] pvV = new int[N], pvE = new int[N];

            while (true) {
                Arrays.fill(dist, INF);
                Arrays.fill(inq, 0);
                Arrays.fill(pvV, -1);
                Arrays.fill(pvE, -1);

                Deque<Integer> q = new ArrayDeque<>();
                dist[s] = 0;
                q.add(s);
                inq[s] = 1;

                // SPFA
                while (!q.isEmpty()) {
                    int u = q.poll();
                    inq[u] = 0;
                    List<Edge> edges = g[u];
                    for (int i = 0; i < edges.size(); i++) {
                        Edge e = edges.get(i);
                        if (e.cap > 0 && dist[e.to] > dist[u] + e.cost) {
                            dist[e.to] = dist[u] + e.cost;
                            pvV[e.to] = u;
                            pvE[e.to] = i;
                            if (inq[e.to] == 0) {
                                inq[e.to] = 1;
                                // small-label-first heuristic
                                if (!q.isEmpty() && dist[e.to] < dist[q.peekFirst()]) q.addFirst(e.to);
                                else q.addLast(e.to);
                            }
                        }
                    }
                }

                if (pvV[t] == -1) break; // no augmenting path

                // find bottleneck
                int aug = Integer.MAX_VALUE;
                for (int v = t; v != s; v = pvV[v]) {
                    Edge e = g[pvV[v]].get(pvE[v]);
                    aug = Math.min(aug, e.cap);
                }

                // apply
                for (int v = t; v != s; v = pvV[v]) {
                    Edge e = g[pvV[v]].get(pvE[v]);
                    e.cap -= aug;
                    g[v].get(e.rev).cap += aug;
                    cost += (long) aug * e.cost;
                }
                flow += aug;
            }
            return new long[]{flow, cost};
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람 수
        int m = Integer.parseInt(st.nextToken()); // 서점 수

        int[] need = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) need[i] = Integer.parseInt(st.nextToken());

        int[] stock = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) stock[i] = Integer.parseInt(st.nextToken());

        int[][] C = new int[m][n]; // capacity shop i -> person j
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) C[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] D = new int[m][n]; // cost shop i -> person j
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) D[i][j] = Integer.parseInt(st.nextToken());
        }

        // node indexing
        // source = 0
        // shops: 1..m
        // persons: m+1..m+n
        // sink = m+n+1
        int S = 0, T = m + n + 1;
        MinCostMaxFlow mcmf = new MinCostMaxFlow(T + 1);

        // source -> shop
        for (int i = 0; i < m; i++) {
            mcmf.addEdge(S, 1 + i, stock[i], 0);
        }
        // shop -> person (cap=C[i][j], cost=D[i][j])
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (C[i][j] > 0) mcmf.addEdge(1 + i, 1 + m + j, C[i][j], D[i][j]);
            }
        }
        // person -> sink
        for (int j = 0; j < n; j++) {
            mcmf.addEdge(1 + m + j, T, need[j], 0);
        }

        long[] ans = mcmf.minCostMaxFlow(S, T);
        System.out.println(ans[0]); // 최대 구매 수량
        System.out.println(ans[1]); // 그때 최소 배송비 합
    }
}
