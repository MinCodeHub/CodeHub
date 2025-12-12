import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
class Nite {
    int x;
    int y;
    int cnt;

    Nite(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Main {
    static int T;
    static int[] dx = {-2, -1, -2, -1, 2, 1, 2, 1};
    static int[] dy = {-1, -2, 1, 2, -1, -2, 1, 2};
    static boolean[][] visited;
    static int I;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            I = Integer.parseInt(br.readLine());
            visited = new boolean[I][I];

            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            if (x == ex && y == ey) {
                System.out.println(0);
            } else {
                bfs(x, y, ex, ey);
            }
        }
    }

    private static void bfs(int x, int y, int ex, int ey) {
        Queue<Nite> q = new LinkedList<>();
        q.offer(new Nite(x, y, 0));
        visited[x][y] = true;

        while (!q.isEmpty()) {

            Nite n = q.poll();

            if (n.x == ex && n.y == ey) {
                System.out.println(n.cnt);
                return;
            }
            for (int i = 0; i < 8; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= I || ny >= I) {
                    continue;
                }
                if (!visited[nx][ny]) {
                    q.offer(new Nite(nx, ny, n.cnt + 1));
                    visited[nx][ny] = true;
                }

            }

        }

    }
}