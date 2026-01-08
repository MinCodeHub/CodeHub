import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    int cnt;

    Node(int x, int y, int c) {
        this.x = x;
        this.y = y;
        this.cnt = c;
    }
}

public class Main {
    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int startx;
    static int starty;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                if (graph[i][j] == 2) {
                    startx = i;
                    starty = j;
                }
                if (graph[i][j] == 0) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = -1;
                }
            }
        }

        map[startx][starty] = 0;

        bfs(startx, starty);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int startx, int starty) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startx, starty, 0));
        visited[startx][starty] = true;
        while (!q.isEmpty()) {
            Node node = q.poll();

            int x = node.x;
            int y = node.y;
            int cnt = node.cnt;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny]) {
                        if (graph[nx][ny] == 1) {
                            map[nx][ny] = cnt + 1;
                            q.offer(new Node(nx, ny, cnt + 1));
                        }
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}