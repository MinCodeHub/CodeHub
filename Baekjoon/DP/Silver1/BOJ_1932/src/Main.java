import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int[][] dp;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());

    arr = new int[n][n];
    dp = new int[n][n];
    for(int i =0; i<n; i++){
        st = new StringTokenizer(br.readLine());
        for(int j =0; j<=i; j++){
            arr[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    //기초값
    dp[0][0] = arr[0][0];

    //dp 진행
        for(int i = 1; i<n; i++){
            for(int j = 0; j<=i; j++){
                if(j==0){
                    //왼쪽 끝
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                }else if(j == i){//오른쪽 끝
                    dp[i][j] = dp[i-1][j-1]+arr[i][j];
                }else{
                    dp[i][j]= Math.max(dp[i-1][j]+arr[i][j],dp[i-1][j-1]+arr[i][j]);
                }
            }
        }
        int max = 0;
        for(int i =0; i<n; i++){
            max = Math.max(max, dp[n-1][i]);
        }
        System.out.println(max);
    }
}