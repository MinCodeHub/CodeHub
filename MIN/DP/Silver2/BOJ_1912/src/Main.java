import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static Integer[] dp;
    static int max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new Integer[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        max = arr[0];
        recur(N - 1);
        System.out.println(max);
    }

    private static int recur(int N) {
        //탐색하지 않은 인덱스라면
        if (dp[N] == null) {
            dp[N] = Math.max(recur(N - 1) + arr[N], arr[N]);

            //해당 dp[N]과 max중 큰 값으로 max 갱신
            max = Math.max(max, dp[N]);
        }
        //이미 계산 됐으면 바로 반환
        return dp[N];
    }
}