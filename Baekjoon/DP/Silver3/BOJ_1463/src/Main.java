import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int n;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new Integer[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        System.out.println(recursion(n));
    }


    private static int recursion(int n) {
        if (dp[n] == null) {
            if (n % 6 == 0) {
                dp[n] = Math.min(recursion(n - 1), Math.min(recursion(n / 3), recursion(n / 2))) + 1;
            } else if (n % 3 == 0) {
                dp[n] = Math.min(recursion(n / 3), recursion(n - 1)) + 1;
            } else if (n % 2 == 0) {
                dp[n] = Math.min(recursion(n / 2), recursion(n - 1)) + 1;
            } else {
                dp[n] = recursion(n - 1) + 1;
            }
        }
        return dp[n];
    }
}