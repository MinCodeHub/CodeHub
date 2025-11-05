// 2839번 설탕배달

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] DP = new int[N + 1];

        Arrays.fill(DP, 100000);
        DP[0] = 0; // 0kg는 0봉지
        for(int i = 3; i <= N; i++) {
            if(i >= 3 && DP[i-3] != 100000){
                DP[i] = min(DP[i], DP[i-3]+1);
            }
            if(i >= 5 && DP[i-5] != 100000)
            {
                DP[i] = min(DP[i], DP[i-5]+1);
            }
        }
        if(DP[N] == 100000)
            System.out.println(-1);
        else
            System.out.println(DP[N]);

    }
}