import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int N, M;
    static int[][] tomato;
    static Queue<tomato> q = new LinkedList<>();

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {


        // 메모리 측정 시작
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long beforeUsedMem = runtime.totalMemory() - runtime.freeMemory();

        // 시간 측정 시작
        long start = System.currentTimeMillis();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        tomato = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    q.add(new tomato(i, j, 0));
                }
            }
        }
        bfs();


        // 시간 측정 끝
        long end = System.currentTimeMillis();
        System.out.println("실행 시간: " + (end - start) + "ms");

        // 메모리 측정 끝
        long afterUsedMem = runtime.totalMemory() - runtime.freeMemory();
        long usedMem = afterUsedMem - beforeUsedMem;
        System.out.println("사용 메모리: " + (usedMem / 1024) + "KB");


    }

    private static void bfs() {


        int tc = 0;
        while (!q.isEmpty()) {
            tomato t = q.poll();

            int tx = t.x;
            int ty = t.y;
            tc = t.cnt;


            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {

                    if (tomato[nx][ny] == 0) {
                        tomato[nx][ny] = 1;
                        q.add(new tomato(nx, ny, tc + 1));
                    }
                }


            }
        }
        if (checkTomato()) {
            System.out.println(tc);
        } else {
            System.out.println(-1);
        }

    }

    private static boolean checkTomato() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (tomato[i][j] == 0)
                    return false;
                // 덜 익은 토마토가 있다면
            }
        }
        return true;
    }


}

class tomato {
    int x;
    int y;
    int cnt;

    tomato(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}