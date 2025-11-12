import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Node {
    int position;
    int cnt;

    public Node(int position, int cnt) {
        this.position = position;
        this.cnt = cnt;
    }
}

public class Main {
    static int N;
    static int K;
    static Queue<Node> q = new LinkedList<>();
    static HashMap<Integer, Integer> map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[101];
        for (int i = 0; i < N + K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.put(x, y);
        }
        q.offer(new Node(1, 0));
        visited[1] = true;
        bfs();
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Node node = q.poll();
            int position = node.position;
            int cnt = node.cnt;

            if (position == 100) {
                System.out.println(cnt);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = position + i;
                if (next > 100) {
                    continue;
                }
                if (map.containsKey(next)) {
                    next = map.get(next);
                }
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new Node(next, cnt + 1));
                }
            }

        }
    }
}