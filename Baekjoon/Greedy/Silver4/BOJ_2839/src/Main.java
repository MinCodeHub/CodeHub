import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (N > 0) {
            if (N % 5 == 0) {
                //3의 배수일 때
                N = N - 5;
                cnt++;
            } else if (N % 3 == 0) {
                //5의 배수일 때
                N = N - 3;
                cnt++;
            } else {
                if (N >= 5) {
                    N -= 5;
                    cnt++;
                } else {
                    N -= 3;
                    cnt++;
                }

            }
        }

        if (N < 0) {
            System.out.println(-1);
        } else {
            System.out.println(cnt);
        }

    }
}