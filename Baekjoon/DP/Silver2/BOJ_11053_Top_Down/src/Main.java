import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Integer[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        dp = new Integer[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            LIS(i);
        }
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }

    private static int LIS(int N) {

        if (dp[N] == null) {
            dp[N] = 1;

            //N-1부터 0까지 중 N보다 작은 값들을 찾으면서 재귀 호출
            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] < arr[N]) {
                    dp[N] = Math.max(dp[N], LIS(i) + 1);
                }
            }
        }
        return dp[N];

    }
}