import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        int cnt = 0;

        System.out.print("<");
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            cnt++;
            if (cnt != k) {
                queue.offer(tmp);
            } else {
                if (queue.size() == 0) {
                    System.out.print(tmp + ">");
                } else {
                    System.out.print(tmp + ", ");
                }

                cnt = 0;
            }
        }
    }
}