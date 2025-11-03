import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        int high = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            high = Math.max(high, arr[i]); //가장 큰 예산 값
        }

        int max = Integer.parseInt(br.readLine());

        if (sum <= max) {
            System.out.println(high);
            return;
        }

        int low = 1;
        int result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (f(mid) <= max) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // 결과 출력
        System.out.println(result);
    }

    static int f(int h) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += Math.min(arr[i], h);
        }
        return total;
    }

}