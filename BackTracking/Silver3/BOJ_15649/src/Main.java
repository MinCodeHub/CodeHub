import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        //N과 M
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = new int[M];
        permutation(0);

    }

    private static void permutation(int depth) {

        if (depth == M) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
            return; //depth = 1로 돌아감
        }


        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                System.out.printf("ENTER depth=%d, i=%d 선택%n", depth, i);
                visited[i] = true;
                arr[depth] = i + 1;
                permutation(depth + 1);
                visited[i] = false;
                System.out.printf("EXIT  depth=%d, i=%d 원상복구 후 for 계속%n", depth, i);
            }
        }
        System.out.printf("RETURN depth=%d for 끝 → 상위로 복귀%n", depth);
    }
}