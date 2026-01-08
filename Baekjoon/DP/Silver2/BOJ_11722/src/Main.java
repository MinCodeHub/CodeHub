import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr  = new int[N]; //수를 넣을 배열
        int[] dp = new int[N]; //해당 인덱스까지 왔을 때 최 장 길이의 감소하는 부분수열 길이
        int max = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;

        for(int i = 1; i < N; i++){
        int temp = 0;
            for(int j = i-1; j >= 0; j--){
                if(arr[j] > arr[i]){
                    if(dp[j] > temp) {
                        temp = dp[j];
                    }
                }
            }
            dp[i] = temp+1;
            if(dp[i] > max) {
                max = dp[i];
            }
        }
        System.out.println(max);

    }
}