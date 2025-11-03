import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    static int[][] map;
    static int[][] copyMap;
    static Queue<Virus> q = new LinkedList<>();
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int maxSafeZone = 0;

    static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        map = new int[N][M];

        //1. 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 2. 벽세우기

        dfs(0);
        System.out.println(maxSafeZone);



    }

    //벽세우기
    private static void dfs(int wallCnt) {

        if(wallCnt == 3){
            bfs();
            return;
        }

        for(int i =0; i<N; i++){
            for(int j = 0; j<M; j++){
              if(map[i][j]==0){
                  map[i][j] = 1;
                  dfs(wallCnt+1);
                  map[i][j] = 0;
              }
            }
        }
    }

    private static void bfs() {

        copyMap = new int[N][M];

        //복사
        for(int i=0; i<N; i++){
            copyMap[i] = map[i].clone();
        }

        //바이러스 위치 큐에 넣기
        for(int i =0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(copyMap[i][j]==2){
                    q.offer(new Virus(i,j));
                }
            }
        }

        // 바이러스 퍼트리기
        while(!q.isEmpty()){
            Virus v = q.poll();
            int x = v.x;
            int y = v.y;

            for(int i=0; i<4; i++) {
                int nx = x+dx[i];
                int ny = y+ dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M &&copyMap[nx][ny]==0){
                    copyMap[nx][ny] = 2;
                    q.offer(new Virus(nx,ny));
                }
            }
        }

        //안전지대 개수 구하기
        funcSafeZone();
    }

    private static void funcSafeZone() {
        int safezone = 0;

        for(int i =0; i<N; i++){
            for(int j =0; j<M; j++){
                if(copyMap[i][j]==0){
                    safezone++;
                }
            }
        }

        maxSafeZone = Math.max(safezone,maxSafeZone);
    }

}
