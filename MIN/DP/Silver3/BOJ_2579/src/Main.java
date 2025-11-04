import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static int dp[];
    static int score[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new int[301]; //i번째 계단을 반드시 밟고 도착했을 때 얻을 수 있는 최대 점수
        score = new int[301];

        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = score[0];
        dp[1] = score[1];
        dp[2] = score[1] + score[2];
        dp[3] = Math.max(score[1] + score[3], score[2] + score[3]);

        for (int i = 4; i <= N; i++) {
            dp[i] = Math.max(dp[i - 3] + score[i - 1] + score[i], dp[i - 2] + score[i]);
        }
        System.out.println(dp[N]);

    }


}