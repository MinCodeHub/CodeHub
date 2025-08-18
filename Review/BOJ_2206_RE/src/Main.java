\import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static int[][][] visited;

    static Queue<Node> q = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x;
        int y;
        int crash;

        Node(int c, int x, int y) {
            this.x = x;
            this.y = y;
            this.crash = c;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        //입력 : 6 4
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[2][N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        q.offer(new Node(0, 0, 0));
        visited[0][0][0] = 1; //부수지 않았으니까

        System.out.println(bfs());

    }

    private static int bfs() {

        while (!q.isEmpty()) {
            Node node = q.poll();

            int x = node.x;
            int y = node.y;
            int crash = node.crash;

            if (x == N - 1 && y == M - 1) {
                return visited[crash][x][y];
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }


                if (map[nx][ny] == 0) {
                    if (visited[crash][nx][ny] == 0) { //0이고 방문한 적이 없다면
                        q.offer(new Node(crash, nx, ny));
                        visited[crash][nx][ny] = visited[crash][x][y] + 1;
                    }
                } else if (map[nx][ny] == 1) {
                    if (crash == 0) {
                        if (visited[1][nx][ny] == 0) {
                            q.offer(new Node(1, nx, ny));
                            visited[1][nx][ny] = visited[0][x][y] + 1;
                        }
                    }
                }
            }
        }
        return -1;
    }
}