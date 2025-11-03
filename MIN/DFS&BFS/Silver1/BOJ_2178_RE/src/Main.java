import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int x;
    int y;
    int cnt;
    Node(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static Queue<Node> q = new LinkedList<>();
    static boolean[][] visited;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = {-1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N =  Integer.parseInt(st.nextToken());
        M =  Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
          String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));

            }
        }
        q.offer(new Node(0,0,1));
        bfs();
        System.out.println(arr[N-1][M-1]);

    }

    private static void bfs() {

        while(!q.isEmpty()){

            Node n = q.poll();
            int x = n.x;
            int y = n.y;
            int c = n.cnt;

            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                //방문하지 않고 배열 값이 1이라면
                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(!visited[nx][ny] && arr[nx][ny]==1){
                        arr[nx][ny] = c+1;
                        q.offer(new Node(nx, ny, c+1));
                    }
                }

            }
        }

    }
}