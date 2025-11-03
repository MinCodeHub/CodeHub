import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static int[] printArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        printArr = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        permutation(0);


    }

    public static void permutation(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(printArr[i] + " ");
            }
            System.out.println();
            return;
        }
        int before = -1;

        for (int i = 0; i < N; i++) {
            int now = arr[i];

            if (!visited[i] && now != before) {
                before = now;
                visited[i] = true;
                printArr[depth] = arr[i];
                permutation( depth + 1);
                visited[i] = false;
            }


        }

    }
}