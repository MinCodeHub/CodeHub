import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] cost;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        cost = new int[N];
        arr = new int[N-1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        int prev = 0;
        long sum = (long)arr[0] * cost[0];
        prev = cost[0]; //이전 가격

        for (int i = 1; i < N - 1; i++) {
            //다음 비용이 이전보다 크면 이전 가격에서 더 충전
            if (cost[i] > prev) {
                sum += (long) prev * arr[i];
            } else {
                sum += (long) cost[i] * arr[i];
                prev = cost[i];
            }
        }
        System.out.println(sum);
    }
}