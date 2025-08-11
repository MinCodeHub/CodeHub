import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] danji;
    static boolean[][] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        danji = new int[N][N];
        visited = new boolean[N][N];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        cnt = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                danji[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (danji[i][j] == 1 && !visited[i][j]) {
                   int c =  bfs(i, j); //하나의 단지안에 있는 수
                    q.offer(c);
                    cnt++; //단지 수 세기
                }
            }
        }
        System.out.println(cnt);
        while(!q.isEmpty()){
            System.out.println(q.poll());
        }
    }

    private static int bfs(int x, int y) {
        int cc = 1;
        Queue<Danji> q = new LinkedList<>();
        q.offer(new Danji(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Danji d = q.poll();

            int xx =d.x;
            int yy = d.y;

            for (int i = 0; i < 4; i++) {
                int nx = xx + dx[i];
                int ny = yy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && danji[nx][ny] != 0 && !visited[nx][ny]) {
                    danji[nx][ny] = cc + 1;
                    cc++;
                    visited[nx][ny] = true;
                    q.offer(new Danji(nx,ny));
                }
            }
        }


        return cc;
    }

    static class Danji{
        int x;
        int y;
        Danji(int x, int y){
            this.x= x;
            this.y= y;
        }

    }
}