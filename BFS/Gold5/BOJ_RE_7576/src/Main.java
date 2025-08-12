import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato{
    int x;
    int y;
    int day;
    Tomato(int x, int y,int day){
        this.x = x;
        this.y = y;
        this.day = day;
    }
}
public class Main {
    static int M; //가로 칸의 수
    static int N; //세로 칸의 수
    static int[][] tomato;
    static boolean[][] visited;
    static Queue<Tomato> q = new LinkedList<>();

    static int[] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //가로
        N = Integer.parseInt(st.nextToken()); //세로

        tomato = new int[N][M];
        visited = new boolean[N][M];

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(checkTomato()){
            System.out.println(0);
            return;
        }
        for(int i =0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(tomato[i][j]==1 && !visited[i][j]){
                    q.offer(new Tomato(i,j,0)); //익은 토마토가 있으면 일단 큐에 넣기
                    visited[i][j] = true;
                }
            }
        }
        bfs();
        result = 0;
        if(!checkTomato()){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }

    private static boolean checkTomato() {
        for(int i=0; i<N; i++){
            for(int j =0; j<M; j++){
                if(tomato[i][j]==0){
                    return false;
                }else{
                    result = Math.max(result, tomato[i][j]);
                }
            }
        }
        return true;
    }

    private static void bfs() {
        while(!q.isEmpty()){
            Tomato t = q.poll();
            int x = t.x;
            int y = t.y;
            int day = t.day;
            for(int i=0; i<4; i++){
                int nx = dx[i]+x;
                int ny = dy[i]+y;
                //각 범위를 넘지 않고, 토마토가 존재하며, 방문한 적이 없을 때
                if(nx>=0 && nx<N&& ny>=0 && ny<M && !visited[nx][ny] && tomato[nx][ny]!=-1){
                    tomato[nx][ny] = day + 1;
                    visited[nx][ny] = true;
                    q.offer(new Tomato(nx,ny,day+1));
                }
            }
        }
    }




}