import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            int len = str.length();
            int cnt = 0;
            int sum = 0;
            for (int j = 0; j < len; j++) {
                char c = str.charAt(j);
                if (c == 'O') {
                    cnt++;
                    sum += cnt;
                }
                if (c == 'X') {
                    cnt = 0;
                }
            }
            System.out.println(sum);
        }

    }
}