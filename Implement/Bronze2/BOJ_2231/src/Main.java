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

        int flag = 0;

        for (int i = 1; i <= N; i++) {
            int sum = i;
            int tmp = i;
            while (tmp > 0) {
                int n = tmp % 10;
                sum += n;
                tmp = tmp / 10;
            }
            if(sum == N){
                flag = 1;
                System.out.println(i);
                return;
            }
        }
        if(flag == 0){
            System.out.println(0);
        }

    }
}