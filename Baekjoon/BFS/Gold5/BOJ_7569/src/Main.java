import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //토마토
    static int N;
    static int M;
    static int H;
    static int[][][] map;

    static boolean[][][] visited;
    static Queue<Tomato> q = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int result = Integer.MIN_VALUE;

    static class Tomato {
        int h;
        int x;
        int y;
        int cnt;

        Tomato(int h, int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H + 1][N][M];
        visited = new boolean[H + 1][N][M];

        for (int i = 1; i <= H; i++) {
            for (int j = 0; j < N; j++) { //가로 3
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) {
                        Tomato t = new Tomato(i, j, k, 0);
                        q.offer(t);
                        visited[i][j][k] = true;
                    }
                }
            }
        }
        if (checkmap()) {
            System.out.println(0);
            return;
        }

        bfs();
        if (!checkmap()) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }

    private static boolean checkmap() {
        for (int i = 1; i <= H; i++) {
            for (int j = 0; j < N; j++) { //세로
                for (int k = 0; k < M; k++) {

                    if (map[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void bfs() {

        while (!q.isEmpty()) {
            Tomato t = q.poll();

            int h = t.h;
            int x = t.x;
            int y = t.y;
            int cnt = t.cnt;

            result = Math.max(result, cnt);

            for (int i = 0; i < 6; i++) {
                int nh = dh[i] + h;
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nh >= 1 && nh <= H && nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nh][nx][ny] && map[nh][nx][ny] == 0) {
                        Tomato tt = new Tomato(nh, nx, ny, cnt + 1);
                        q.offer(tt);
                        map[nh][nx][ny] = 1;
                        visited[nh][nx][ny] = true;
                    }
                }
            }
        }
    }
}