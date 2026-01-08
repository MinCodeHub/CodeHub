import javax.swing.text.Position;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //자리배정

    static int K;
    static int C, R;

    static int dir = 0;
    static int[][] map;

    static int[] dx = {0, 1, 0, -1}; //위 오 아 왼
    static int[] dy = {-1, 0, 1, 0}; //위 오 아 왼 순서로 배치


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken()); //가로 (열) 7
        R = Integer.parseInt(st.nextToken()); //세로(행)  6

        K = Integer.parseInt(br.readLine());

        if (K > R * C) {
            System.out.println(0);
            return;
        }

        int num = 1;
        map = new int[R][C]; // (행, 열)

        int x = 0;
        int y = R - 1; //시작 좌표
        map[y][x] = num;

        while (num < K) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            //범위 체크
            if (nx >= 0 && nx < C && ny >= 0 && ny < R && map[ny][nx] == 0) {
                num++;
                x = nx;
                y = ny;
                map[y][x] = num;
            } else {
                dir = (dir + 1) % 4;
            }
        }

        System.out.println((x + 1) + " " + (R - y));
    }

}
