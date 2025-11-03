import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int result;
    static int[] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        //피보나치 수는 0과 1로 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        if(n==0){
            System.out.println(0);
        }else{
            dp[0] = 0;
            dp[1]= 1;
            result = fibo(2);
            System.out.println(result);
        }
    }

    private static int fibo(int start) {
        if(start > n){
            return dp[n];
        }else{
            dp[start] = dp[start-1]+ dp[start-2];
            fibo(start+1);
        }
        return dp[n];
    }
}