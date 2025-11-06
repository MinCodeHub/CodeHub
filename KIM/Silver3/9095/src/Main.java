import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();


        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] DP = new int[11];

            DP[1] = 1;
            DP[2] = 2;
            DP[3] = 4;
            for(int j = 4; j <= n; j++) {
                DP[j] = DP[j - 3] + DP[j - 2] + DP[j - 1];
            }
            System.out.println(DP[n]);
        }

    }
}