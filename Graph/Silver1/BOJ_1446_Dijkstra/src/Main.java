import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int idx, cost;

    Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    public int compareTo(Node o) {
        return this.cost - o.cost; // 비용이 작은 순으로 우선순위 큐 정렬
    }
}

class Road {
    int start, end, distance;

    public Road(int s, int e, int d) {
        this.start = s;
        this.end = e;
        this.distance = d;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 지름길 개수
        int D = Integer.parseInt(st.nextToken()); // 도착 지점

        List<Road> roads = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            // 유효한 지름길만 추가 (도착 지점을 넘지 않고, 지름길이 실제로 이득인 경우)
            if (e <= D && (e - s) > d) {
                roads.add(new Road(s, e, d));
            }
        }

        // 다익스트라
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int location = cur.idx;

            if (cur.cost > dist[location]) continue;

            // 일반 도로로 한 칸 이동
            if (location + 1 <= D && dist[location + 1] > dist[location] + 1) {
                dist[location + 1] = dist[location] + 1;
                pq.add(new Node(location + 1, dist[location + 1]));
            }

            // 지름길 사용
            for (Road r : roads) {
                if (r.start == location && r.end <= D) {
                    if (dist[r.end] > dist[location] + r.distance) {
                        dist[r.end] = dist[location] + r.distance;
                        pq.add(new Node(r.end, dist[r.end]));
                    }
                }
            }
        }

        System.out.println(dist[D]);
    }
}
