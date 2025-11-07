import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] DP = new int[1001];

        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 1;
        // SK = 1, CY = 2;
        for(int i = 4; i <= n; i++) {
            if(DP[i-1] == 1 || DP[i-3] == 1)
                DP[i] = 2;
            else
                DP[i] = 1;
        }

        if(DP[n] == 1)
            System.out.println("SK");
        else
            System.out.println("CY");
    }
}

// 홀수면 SK, 짝수면 CY가 이기는 규칙을 가지는 문제임