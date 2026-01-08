import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;

        for(int i = 4; i<=n; i++){
            dp[i] = (dp[i-2] * 2 + dp[i-1])% 10007;
        }

        System.out.println(dp[n] % 10007);
    }
}