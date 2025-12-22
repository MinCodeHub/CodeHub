import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        if(n == 1){
            dp[0] = 0;
            dp[1] = 0;
        }else{
            dp[0] = 0;
            dp[1] = 0;
            dp[2] = 1;
        }


        for(int i = 3; i <= n; i++){
            if(i % 6 == 0){
               dp[i] = Math.min(dp[i/3],Math.min(dp[i/2], dp[i-1])) +1;
            }else if(i % 3 == 0){
                dp[i] =  Math.min(dp[i/3], dp[i-1])+1;
            }else if(i % 2 == 0){
                dp[i] =  Math.min(dp[i/2], dp[i-1])+1;
            }else{
                dp[i] = dp[i-1]+1;
            }
        }
        System.out.println(dp[n]);
    }


}