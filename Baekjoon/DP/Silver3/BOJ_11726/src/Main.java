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
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i<=n; i++){
            dp[i] = (dp[i-2]+dp[i-1]) %10007 ;
        }
        System.out.println(dp[n] % 10007);

    }
}