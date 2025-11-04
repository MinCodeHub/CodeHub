import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//dp RGB 다시 풀기
public class Main {
    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i =1; i<N; i++){
            cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
            cost[i][1] += Math.min(cost[i-1][2], cost[i-1][0]);
            cost[i][2] += Math.min(cost[i-1][1], cost[i-1][0]);
        }
        int min = Math.min(cost[N-1][0], Math.min(cost[N-1][1],cost[N-1][2]));
        System.out.println(min);

    }
}