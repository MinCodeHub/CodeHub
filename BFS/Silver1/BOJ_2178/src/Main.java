import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static int[][] arr;
    static boolean[][] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        for(int i =1; i<=N; i++){
          String str = br.readLine();
            for(int j = 1; j<=M; j++){
                arr[i][j] =  str.charAt(j-1)-'0';
            }
        }

      visited  = new boolean[N+1][M+1];


        bfs();
        System.out.println(arr[N][M]);
    }

    private static void bfs() {

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1,1));
        visited[1][1] = true;

        while(!q.isEmpty()){
           Node node = q.poll();
            int x = node.x;
            int y = node.y;

            for(int i =0; i < 4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx > 0 && ny > 0 && nx <= N && ny <= M && arr[nx][ny] != 0 && !visited[nx][ny]){
                        q.offer(new Node(nx,ny));
                        visited[nx][ny] = true;
                        arr[nx][ny] = arr[x][y] + 1;
                    }
                }
            }

        }


    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}