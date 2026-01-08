import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int[][][] dp;
    static int a, b, c;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        dp = new int[21][21][21];

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, W(a, b, c));
            W(a, b, c);

        }
    }

    public static int W(int a, int b, int c) {
        if (a>=0 && a<=20 && b>=0 && b<=20 && c>=0 && c<=20 && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        } else if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = W(20, 20, 20);
        } else if (a < b && b < c) {
            return dp[a][b][c] = W(a, b, c - 1) + W(a, b - 1, c - 1) - W(a, b - 1, c);
        } else {
            return dp[a][b][c] = W(a - 1, b, c) + W(a - 1, b - 1, c) + W(a - 1, b, c - 1) - W(a - 1, b - 1, c - 1);
        }
    }

}