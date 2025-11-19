import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][10]; //N자리 수에 앞자리가 0,1,2,3,4,5,6,7,8,9 일때

        dp[1][0] = 0;
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % 1000000000;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % 1000000000;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                }

            }
        }
        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[N][i];
        }
        System.out.println(sum % 1000000000);
    }
}