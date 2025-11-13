import java.awt.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        sc.nextLine();

        int[][] mat  = new int[N][M];
        int[][] visited = new int[N][M];

        // mat 생성
        for(int i = 0; i < N; i++) {
            String data = sc.nextLine();
            for(int j = 0; j < M; j++) {
                mat[i][j] = data.charAt(j) - '0';
            }
        }

        int[] near_x = {0, -1, 0, 1};
        int[] near_y = {1, 0, -1, 0};

        Queue<Point> queue = new LinkedList<>();
        int x, y;
        queue.offer(new Point(0,0));
        visited[0][0] = 1; // (0, 0)에서 시작

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            for(int i = 0; i < 4; i++)
            {
                x = point.x + near_x[i];
                y = point.y + near_y[i];

                if(x >= 0 && x < N && y >= 0 && y < M && visited[x][y] == 0 && mat[x][y] != 0)
                {
                    queue.offer(new Point(x,y));
                    visited[x][y] = visited[point.x][point.y] + 1;
                }
            }
        }

        System.out.println(visited[N-1][M-1]);

    }
}