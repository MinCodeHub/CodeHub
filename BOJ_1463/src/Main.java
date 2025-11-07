import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int n;
    static int[] dp;
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        dp[1] = 0;
        if (n == 1) {
            System.out.println(0);
            return;
        } else {
            for (int i = 2; i <= n; i++) {
                cnt = 0;
                recursion(i);
                dp[i] = cnt;
            }
        }
        System.out.println(dp[n]);

    }

    private static void recursion(int n) {
        if (dp[n] == 0) {
            if (n % 6 == 0) {
                //공배수일 때
                cnt = Math.min(dp[n / 3] + 1, dp[n / 2] + 1);
            } else if (n % 3 == 0) {
                cnt = Math.min(dp[n / 3] + 1, dp[n - 1] + 1);
            } else if (n % 2 == 0) {
                cnt = Math.min(dp[n / 2] + 1, dp[n - 1] + 1);
            } else {
                n = n - 1;
                cnt = dp[n] + 1;
            }
        }
    }
}