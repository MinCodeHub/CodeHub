import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        dp = new long[101];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            long ans = w(n);
            System.out.println(ans);
        }
    }

    private static long w(int n) {
        if (dp[n - 1] != 0) {
            return dp[n - 1];
        }
        for (int i = 5; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }
        return dp[n - 1];
    }
}