import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    static int N;

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());

        }

        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);

            if (i + T[i] - 1 <= N) {
                dp[i+T[i] -1] = Math.max(dp[i+T[i]-1],dp[i-1]+P[i]);
            }
        }
        System.out.println(dp[N]);

    }
}