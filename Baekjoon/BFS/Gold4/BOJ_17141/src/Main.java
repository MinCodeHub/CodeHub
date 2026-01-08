import java.io.*;
import java.util.*;
public class Main {

    static int n;
    static int m;
    static int [][] map;
    static ArrayList<Virus> virus = new ArrayList<>();

    static boolean[] virus_visited; //조합을 위한 방문여부 배열
    static int[] virus_arr; //뽑은 m개를 담을 배열
    static int [][] copyMap;
    static boolean [][] visited;
    static int[] dx={-1,0,1,0};
    static int[] dy ={0,1,0,-1};

    static int max = -1;
    static int result = Integer.MAX_VALUE;
    static class Virus{
        int x;
        int y;
        int time;
        public Virus(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    virus.add(new Virus(i,j,0)); //바이러스가 놓일 수 있는 위치 저장
                }
            }
        }
        virus_visited = new boolean[virus.size()];
        virus_arr = new int[m];

        //바이러스가 놓일 수 있는 위치들 중에서 m개를 뽑아야함. 중복없는 조합
        dfs(0,0);

        if(result == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }

    }

    private static void dfs(int level, int start) {

        if(level == m){
            bfs(); //m개를 다 뽑았다면 bfs를 실행해라
            return;
        }

        for(int i = start; i < virus.size(); i++){
            if(!virus_visited[i]){
                virus_arr[level] = i;
                virus_visited[i] = true;
                dfs(level+1, i+1);
                virus_visited[i] = false;
            }
        }
    }
    public static void copy(){
        copyMap= new int[n][n];
        visited = new boolean[n][n];

        for(int i =0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(map[i][j] == 2){
                    copyMap[i][j] = 0;
                }else{
                    copyMap[i][j]  = map[i][j];
                }
            }
        }


    }

    private static void bfs() {
        max  = -1;

        copy(); //배열 복사하고
        Queue<Virus> q = new LinkedList<>();
        for(int i=0; i<m; i++){ //조합에서 뽑은 m개를 큐에 넣는다?
            Virus v = virus.get(virus_arr[i]);
            int x = v.x;
            int y = v.y;
            int t = v.time;
            visited[x][y] = true;
            q.offer(new Virus(x,y,t));
            copyMap[x][y] = 2;
        }

        while(!q.isEmpty()){
            Virus v = q.poll();
            int x = v.x;
            int y = v.y;
            int t = v.time;

            max = Math.max(max, t);

            for(int i=0; i<4; i++){
                int nx = x+ dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n){
                    if(!visited[nx][ny] && copyMap[nx][ny] == 0){
                        copyMap[nx][ny] = 2;
                        visited[nx][ny] = true;
                        q.offer(new Virus(nx,ny,t+1));
                    }
                }
            }
        }

        if(isPossible()){
          result = Math.min(max,result);
        }


    }

    private static boolean isPossible() {
        for(int i =0; i<n; i++){
            for(int j =0; j<n; j++){
                if(copyMap[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }


}
