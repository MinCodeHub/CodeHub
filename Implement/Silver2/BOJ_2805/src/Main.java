import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long M;

    static int[] tree;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        tree = new int[N];

        int left = 0;
        int right = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, tree[i]);
        }
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            long count = solve(mid);
            if (count >= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);

    }

    private static long solve(int mid) {
        long cnt = 0;

        for (int i = 0; i < N; i++) {
            if (mid < tree[i]) {
                cnt += tree[i] - mid;
            }
        }
        return cnt;
    }
}