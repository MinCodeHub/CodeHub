import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Birus {
    int x;
    int y;

    public Birus(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N;
    static int M;
    static Queue<Birus> q;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static int[][] copymap;
    static int maxSafeZone = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copymap = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(maxSafeZone);

    }

    private static void dfs(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }


    }

    private static void bfs() {
        q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    q.offer(new Birus(i, j));
                }
            }
        }

        copymap = new int[N][M];

        for (int i = 0; i < N; i++) {
            copymap[i] = map[i].clone();
        }

        while (!q.isEmpty()) {
            Birus birus = q.poll();
            int x = birus.x;
            int y = birus.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx < 0 || ny<0|| nx>=N || ny>=M)
                    continue;

                if (copymap[nx][ny] == 0) {
                    copymap[nx][ny] = 2;
                    q.offer(new Birus(nx, ny));
                }
            }
        }

        safeZone();
    }

    private static void safeZone() {
        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copymap[i][j] == 0) {
                    safe++;
                }
            }
        }
        maxSafeZone = Math.max(maxSafeZone, safe);


    }
}

