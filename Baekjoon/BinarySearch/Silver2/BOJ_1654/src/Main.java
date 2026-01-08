import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int k;
    static int n;
    static int[] arr;
    static long result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[k];
        long max = 0;

        for(int i = 0; i < k; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        max = arr[k-1];
        check(1, max);
        System.out.println(result);
    }

    private static void check(long start, long end) {
        if (start > end) {
            return;
        }

        long mid = (start + end) / 2;

        long cnt = 0;
        for (int i = 0; i < k; i++) {
            cnt += arr[i] / mid;
        }
        if (cnt >= n) {
            result = mid;
            check(mid + 1, end);
        } else {
            check(start, mid - 1);
        }
    }
}