import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] map;

    static int[] dx = {-1,0,1,0}; //위 오 아 왼
    static int[] dy ={0,1,0,-1};

    static int K;
    static int rx;
    static int ry;


    public static void main(String[] args) throws IOException {
       //달팽이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];

        int x = (N - 1) / 2;
        int y = (N -1) / 2;

        rx =0;
        ry = 0;
        int num = 1;
        int timing = 1; //반복 -> 고정
        int t = 0;  // 따라가는 아이

        map[x][y] = num;

        int dir = 0;
        int cnt = 0;

        while(num < N*N) {

            int nx = x + dx[dir];
            int ny = y + dy[dir];



            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 0) {
                num++;
                map[nx][ny] = num;
                x = nx;
                y = ny;


                t++;

                if(timing == t){
                    dir = (dir + 1) % 4;
                    t=0;
                }

                cnt++;
                if(cnt == (2*timing)){
                    cnt =0;
                    timing+=1; // 방향 바뀌는 타이밍을 하나씩 늘림
                }
            }
        }

        for(int i =0; i<N; i++){
            for(int j = 0; j<N; j++){
                System.out.print(map[i][j]+" ");
                if(map[i][j] == K){
                    rx = i;
                    ry = j;

                }
            }
            System.out.println();
        }

        System.out.print((rx+1)+" "+(ry+1));

    }
}