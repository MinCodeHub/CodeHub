import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken()); //게임 횟수
        long y = Long.parseLong(st.nextToken()); //이긴 게임
        long z = y * 100 / x; //현재 승률

        if (z >= 99) {
            System.out.println(-1);
            return;
        }
        long left = 1;
        long right = 1000000000;
        long answer = -1;

        while (left <= right) {
            long mid = (left + right) / 2;
            long newWinRate = (y + mid) * 100 / (x + mid);

            if (newWinRate > z) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }

}
