import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
        static int n;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       n = Integer.parseInt(br.readLine());

       long[][] dp = new long[n+1][2];

       dp[1][0] = 0;
       dp[1][1] = 1;

       if(n == 1){
           System.out.println(1);
           return;
       }

       for(int i = 2; i<=n; i++){
           dp[i][0] = dp[i-1][0]+ dp[i-1][1];
           dp[i][1] = dp[i-1][0];
       }

       long sum = dp[n][0]+ dp[n][1];
       System.out.println(sum);

    }
}