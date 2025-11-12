import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[301];
        int[] DP = new int[301];

        for(int i = 1; i <= n; i++)
            list[i] = sc.nextInt();

        DP[0] = 0;
        DP[1] = list[1];
        DP[2] = list[1] + list[2];

        for(int i = 3; i <= n; i++)
            DP[i] = Math.max(DP[i-2] + list[i], DP[i-3] + list[i-1] + list[i]);
        System.out.println(DP[n]);
    }
}