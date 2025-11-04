import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            T[i] = scan.nextInt();
            P[i] = scan.nextInt();
        }

        int[] DP = new int[N + 2];

        for (int i = N; i >= 1; i--) {
            int finishDay = i + T[i]; // i일 상담을 완료 다음날

            // 1. i일 상담을 할 수 없는 경우
            if (finishDay > N + 1) {
                // 오늘 상담을 포기하고, 내일(i+1일)의 최대 수익을 그대로 가져옴
                DP[i] = DP[i + 1];
            }
            // 2. i일 상담을 할 수 있는 경우
            else {
                // i일 상담을 포기했을 때의 최대 수익 (내일의 최대 수익)
                int profit_not_taking = DP[i + 1];

                // i일 상담을 했을 때의 최대 수익
                // (i일 수익 P[i]) + (i일 상담이 끝난 날(finishDay) 이후의 최대 수익 DP[finishDay])
                int profit_taking = P[i] + DP[finishDay];

                // 두 옵션 중 더 큰 값을 선택하여 DP[i]에 저장
                DP[i] = Math.max(profit_not_taking, profit_taking);
            }
        }
        System.out.println(DP[1]);

        scan.close();

    }
}