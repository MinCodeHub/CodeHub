import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int T;
    static int count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            count = 0;
            dfs(num, 0);
            System.out.println(count);

        }
    }

    private static void dfs(int num, int sum) {

        if (num == sum) {
            count++;
            return;
        }
        if (sum > num) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            dfs(num, sum + i);
        }
    }
}