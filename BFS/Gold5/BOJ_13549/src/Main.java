import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static boolean[] visited;
    static Queue<Node> q = new LinkedList<>();

    static class Node {
        int x;
        int t;

        Node(int x, int t) {
            this.x = x;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[200002];

        if (N == K) {
            System.out.println(0);
            return;
        }

        Node n = new Node(N, 0);
        q.offer(n);
        bfs();

    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Node n = q.poll();

            int x = n.x;
            int t = n.t;
            if (x == K) {
                System.out.println(t);
                return;
            }
            if (x * 2 >= 0 && x * 2 < 200002 && !visited[x * 2]) {
                q.offer(new Node(x * 2, t));
            }
            if (x - 1 >= 0 && x - 1 < 100001 && !visited[x - 1]) {
                q.offer(new Node(x - 1, t + 1));
            }
            if (x + 1 >= 0 && x + 1 < 100001 && !visited[x + 1]) {
                q.offer(new Node(x + 1, t + 1));
            }


            visited[x] = true;
        }
    }
}