import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int [][] arr = new int[n][3];

        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int []dp = new int[d+1];
        //arr[j][0] 시작위치 [1] 도착위치 [2] 걸리는 시간
        //우선 그냥 걸어간다는 하에 dp에 값을 넣어줌
        for(int i = 0; i<=d;i++){
            dp[i] = i;
        }

        for(int i = 1; i<=d; i++){
            dp[i] = Math.min(dp[i], dp[i-1]+1); //일반도로로 오거나, 지름길로 오거나 쩃든 작은 값
            for(int j = 0; j<n; j++){ //지름길
                if(arr[j][1] == i){
                    //해당 지점 i에 도착하는 지름길이 있다면, 그 지름길을 사용한 경우의 시간과 비교
                    dp[i]= Math.min(dp[i], dp[arr[j][0]]+arr[j][2]);
                }
            }
        }

        System.out.println(dp[d]);










    }
}