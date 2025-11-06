import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] DP = new int[n+1];
        Arrays.fill(DP, 100000);
        DP[0] = 0;

        for(int i = 2; i <= n; i++) {
            if(i >= 2 && DP[i-2] != 100000)
                DP[i] = Math.min(DP[i], DP[i-2]+1);
            if(i >= 5 && DP[i-5] != 100000)
                DP[i] = Math.min(DP[i], DP[i-5]+1);
        }

        if(DP[n] != 100000)
            System.out.println(DP[n]);
        else
            System.out.println(-1);
        sc.close();
    }
}