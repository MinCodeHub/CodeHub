import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        if(n == 1){
            System.out.println(score[1]);
            return;
        }
        dp[1] = score[1]; //1번째를 먹었을 때 최대
        dp[2] = score[1] + score[2]; //2번째를 먹었을 때 최대

        for (int i = 3; i <= n; i++) {
            //3번쨰를 먹을 때와 안먹을 때로 나눔.
            //안먹는다면 dp[2] 가 됨.
            //먹는다면 나올 수 있는 경우의 수가 1->3, 2->3 인데

            int ans1 = dp[i - 2] + score[i];
            int ans2 = dp[i - 3] + score[i - 1] + score[i];

            dp[i] = Math.max(dp[i - 1], Math.max(ans1, ans2));
        }
        System.out.println(dp[n]);

    }
}