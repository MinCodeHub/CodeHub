import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] dp;
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N - K + 1];
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int j = 0; j < K; j++) {
            sum += arr[j];
        }
        dp[0] = sum;
        result = dp[0];

        for (int i = 1; i < N - K + 1; i++) {
            dp[i] = dp[i - 1] - arr[i - 1] + arr[i + K - 1];
            result = Math.max(dp[i], result);
        }


        System.out.println(result);
    }
}