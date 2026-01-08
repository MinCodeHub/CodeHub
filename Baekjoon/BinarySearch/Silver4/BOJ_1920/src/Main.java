import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int n;
    static int m;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int cur = Integer.parseInt(st.nextToken());
            int ans = checkIn(cur, 0, n - 1);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static int checkIn(int cur, int start, int end) {
        if(start > end)
            return 0; //이게 빠져서 스택오버 플로우가 났었음.

        int mid = (start + end) / 2;
        if (arr[mid] == cur) {
            return 1;
        }
        if (arr[mid] > cur) {
            return checkIn(cur, 0, mid-1);
        } else {
            return checkIn(cur, mid + 1, end);
        }
    }
}