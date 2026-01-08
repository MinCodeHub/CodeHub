import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int M;
    static int[] card;
    static int sum;
    static int result = Integer.MIN_VALUE;

//  if (sum > M) return;  //가지치기 안해줘서 시간초과 남.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        card = new int[N];
        sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        for (int j = 0; j < N; j++) {
            combination(j, 3);
        }

        System.out.println(result);
    }

    private static void combination(int start, int depth) {
        if (depth == 0) { //3개 다 뽑았다면 합을 구함
            if (sum <= M) {
                result = Math.max(result, sum);
                return;
            }
        }

        if (sum > M) return;  //가지치기 안해줘서 시간초과 남.

        for (int i = start; i < N; i++) {
            sum += card[i];
            combination(i + 1, depth - 1);
            sum -= card[i];
        }
    }
}