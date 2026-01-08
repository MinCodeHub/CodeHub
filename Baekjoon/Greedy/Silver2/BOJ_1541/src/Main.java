import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        int sum = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        while (st.hasMoreTokens()) {
            int temp = 0;

            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");

            while (st2.hasMoreTokens()) {
                temp += Integer.parseInt(st2.nextToken());
            }

            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            }else{
                sum-=temp;
            }
        }
        System.out.println(sum);
    }
}