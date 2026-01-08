import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[][] forest;
    static int n;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        forest = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j));
            }
        }
        System.out.println(max);
    }

    private static int dfs(int x, int y) {
        if (dp[x][y] != 0)
            return dp[x][y];

        dp[x][y] = 1;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                continue;
            //“(x,y)에서 갈 수 있는 모든 더 큰 칸(nx,ny) 중에서
            //그 칸에서 출발했을 때의 최장 경로 + 1
            //이 값들 중 가장 큰 값을 dp[x][y]에 저장한다.”
            if (forest[nx][ny] > forest[x][y]) {
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
            }
        }
        return dp[x][y];
    }
}