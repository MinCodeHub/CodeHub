import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static  Integer[] dp;
    static int[][] wire;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N];
        wire = new int[N][2]; //wire[N][0] = A 전봇대, wire[N][1] = B 전봇대

        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine()," ");
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        //전봇대 A를 기준으로 해서 오름차순
        Arrays.sort(wire, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });

        int max = 0;

        for(int i = 0; i<N; i++){
            max = Math.max(LIS(i),max);
        }

        System.out.println(N - max);
    }

    private static int LIS(int n) {
        if(dp[n] == null){
            dp[n] = 1;

            for(int j = n + 1; j<dp.length; j++){
                if(wire[n][1] < wire[j][1]){
                    dp[n] = Math.max(dp[n], LIS(j)+1);
                }
            }
        }
        return dp[n];
    }
}