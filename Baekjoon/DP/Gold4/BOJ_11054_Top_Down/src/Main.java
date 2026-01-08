import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//LIS , LDS 탑 다운
public class Main {
    static Integer[] r_dp;
    static Integer[] l_dp;
    static int[] seq;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        r_dp = new Integer[N]; // 오름차순
        l_dp = new Integer[N]; // 내림차순
        seq = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        //배열 넣어주고
        for(int i = 0; i < N; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for(int i =0; i<N; i++){
            LIS(i); //오름차순
            LDS(i); //내림차순
        }

        int max = -1;

        for(int i =0; i<N; i++){
            max = Math.max(r_dp[i]+l_dp[i], max);
        }

        System.out.println(max - 1);

    }

    //내림차순
    private static int LDS(int N) {
        if(l_dp[N] == null){
            l_dp[N] = 1; //1로 초기화

            for(int i = N+1; i < l_dp.length; i++){
                if(seq[i] < seq[N]){
                    l_dp[N] = Math.max(l_dp[N], LDS(i) + 1);
                }
            }
        }
        return l_dp[N];
    }

    //오름차순
    private static int LIS(int N) {
        if (r_dp[N] == null) {

            r_dp[N] = 1; //1로 초기화

            //이전 노드들
            for(int i = N - 1; i >= 0; i--){
                if(seq[i] < seq[N]){
                 r_dp[N] = Math.max(r_dp[N], LIS(i)+1);
                }
            }

        }
        return r_dp[N];
    }
}