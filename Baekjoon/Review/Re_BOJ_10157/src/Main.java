import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //자리 배정

    static int C;
    static int R;
    static int K;
    static int[][] map;
    static int num;

    static int[] dx = {-1, 0, 1, 0}; //위 오 아 왼
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        K = Integer.parseInt(br.readLine());
        if (K > R * C) {
            System.out.println(0);
            return;
        }
        num = 1;
        int dir = 0;

        map[R - 1][0] = num;

        int x = R - 1;
        int y = 0;

        while (num < K) {

            int nx = x + dx[dir];
            int ny = y + dy[dir];


            if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == 0) {
                num++;
                x = nx;
                y = ny;
                map[nx][ny] = num;

            } else {
                dir = (dir + 1) % 4;
            }
        }

        System.out.println((y + 1) + " " + (R - x));


    }
}