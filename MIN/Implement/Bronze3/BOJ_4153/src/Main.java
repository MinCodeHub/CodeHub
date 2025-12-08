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
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());
            if (x1 == 0 && x2 == 0 && x3 == 0) {
                System.out.println(sb);
                break;
            }

            if (checking(x1, x2, x3)) {
                sb.append("right").append("\n");
            } else if (checking(x2, x1, x3)) {
                sb.append("right").append("\n");

            } else if (checking(x3, x2, x1)) {
                sb.append("right").append("\n");

            } else {
                sb.append("wrong").append("\n");
            }
        }

    }

    static boolean checking(int a, int b, int c) {
        if (a * a == b * b + c * c) {
            return true;
        }
        return false;
    }

}