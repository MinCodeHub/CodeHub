import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];

        for(int i =0; i<=9; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i <= N; i++){
            dp[i][0] = 1;
            for(int j = 1; j<=9;j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) %10007;
               // System.out.println("dp["+i+"]["+j+"]="+dp[i][j]);
            }
        }
        int sum =0;
        for(int i =0; i<=9; i++){
            sum+=dp[N][i] %10007;
        }

        System.out.println(sum  %10007);
    }
}
