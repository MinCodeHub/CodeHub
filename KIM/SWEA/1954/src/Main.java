import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();

            int[][] mat = new int[N][N];

            int[] dr = {0, 1, 0, -1};
            int[] dc = {1, 0, -1, 0};
            int dir = 0; // 우

            int r = 0;
            int c = 0;

            for(int i = 1; i <= N*N; i++) {
                mat[r][c] = i;

                int next_r = r + dr[dir];
                int next_c = c + dc[dir];

                if (next_r < 0 || next_c < 0 || next_r >= N || next_c >= N || mat[next_r][next_c] != 0)
                {
                    dir = (dir + 1) % 4;
                    next_r = r + dr[dir];
                    next_c = c + dc[dir];
                }

                r = next_r;
                c = next_c;

            }

            System.out.println("#" + test_case);
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}