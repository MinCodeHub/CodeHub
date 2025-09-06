import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] f;
    static int fcnt;
    static int fibocnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        fcnt = 0;
        fibocnt = 0;
        fib(N);

        f = new int[N + 1];
        fibonacci(N);

        System.out.println(fcnt +" "+ fibocnt);
    }

    private static int fibonacci(int n) {
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            fibocnt++;
        }
        return f[n];
    }


    private static int fib(int n) {

        if (n == 1 || n == 2) {
            fcnt++;
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}