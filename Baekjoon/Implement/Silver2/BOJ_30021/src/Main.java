import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb;
    static boolean done = false;
    static int[] prefix;
    static boolean[] isPrime; //미리 게산된 소수 정보

    public static void main(String[] args) throws IOException {
        //순열 선물하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        visited = new boolean[N + 1];
        prefix = new int[N + 1];

        int maxSum = N * (N + 1) / 2;

        isPrime = new boolean[maxSum + 1];

        sieve(maxSum);
        permutation(1);

        if (!done) {
            System.out.println("NO");
        }
    }


    //에라토스테네스의 체
    static void sieve(int max) {
        if (max < 2)
            return;

        boolean[] check = new boolean[max + 1];

        check[0] = check[1] = true;

        for (int i = 2; i * i <= max; i++) {
            if (!check[i]) {
                for (int j = i * i; j <= max; j += i) {
                    check[j] = true; //소수가 아님
                }
            }
        }

        for (int i = 2; i <= max; i++) {
            isPrime[i] = !check[i];
        }

    }

    //순열 함수
    static void permutation(int depth) {
        if (done) return;

        if (depth == N + 1) {
            System.out.println("YES");
            for (int i = 1; i <= N; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            done = true;
            return;
        }

        for (int k = 1; k <= N; k++) {
            if (!visited[k]) {
                int nextSum = prefix[depth - 1] + k;
                if (isPrime[nextSum]) //소수이면 버림
                    continue;

                arr[depth] = k;
                visited[k] = true;
                prefix[depth] = nextSum;
                permutation(depth + 1);
                visited[k] = false;
            }

        }
    }

}