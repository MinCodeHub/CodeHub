import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            int max = 0;
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int r3 = Integer.parseInt(st.nextToken());

            if (r1 == 0 && r2 == 0 && r3 == 0) {
                break;
            }
            max = Math.max(max, r1);
            max = Math.max(max, r2);
            max = Math.max(max, r3);
            int sum = r1 + r2 + r3;

            if (max >= sum - max) {
                sb.append("Invalid");
            } else if (r1 == r2 && r2 == r3) {
                sb.append("Equilateral");
            } else if (r1 == r2 || r1 == r3 || r2 == r3) {
                sb.append("Isosceles ");
            } else {
                sb.append("Scalene");
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }
}