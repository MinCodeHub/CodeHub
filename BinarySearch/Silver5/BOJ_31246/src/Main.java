import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //이분탐색
    static int n;
    static int k;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int maxDiff = 0; //얼만큼 올릴지

        arr = new int[n][2];

        for(int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i][0] = a;
            arr[i][1] = b;

            maxDiff = Math.max(maxDiff, b - a); //가장 큰 차이 값을 찾음
        }

        int left = 0;
        int right = maxDiff;
        int answer = -1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(canWin(mid)){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean canWin(int x) {
        int cnt = 0;

        for(int i = 0; i < n; i++){
            int a = arr[i][0];
            int b = arr[i][1];

            if(a + x >= b){
                cnt++;
            }
        }
        return cnt >= k;
    }
}