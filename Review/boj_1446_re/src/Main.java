import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //지름길 복습
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][3];

        int[] dp = new int[d+1];

        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i <= d; i++){
            dp[i] = i;
        }
        for(int i = 1; i<=d; i++){
            dp[i] = Math.min(dp[i], dp[i-1]+1);
            for(int j = 0; j<n; j++){
                if(arr[j][1]==i){
                    dp[i] = Math.min(dp[i], dp[arr[j][0]]+arr[j][2]);
                }
            }
        }
        System.out.println(dp[d]);
    }
}