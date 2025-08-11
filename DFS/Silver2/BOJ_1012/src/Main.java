import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int N;
    static int K;
    static int T; //테스트 케이스

    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken()); //가로길이 10
            N = Integer.parseInt(st.nextToken()); //세로길이 8
            K = Integer.parseInt(st.nextToken()); //배추가 심어져있는 위치의 개수

            arr = new int[N][M]; //[8][10]
            visited = new boolean[N][M];
            int cnt = 0;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int y1 = Integer.parseInt(st.nextToken()); //가로
                int x1 = Integer.parseInt(st.nextToken()); //세로

                arr[x1][y1] = 1;

            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");

        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 1 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx,ny);
            }
        }
    }
}