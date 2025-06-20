import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.StringTokenizer;

// mid 변수의 의미가 구간 범위구나
//그 구간범위를 이분탐색

public class Main {

    static int N;
    static int M;
    static int[] arr;

    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        String[] ss = str.split(" ");
        int right = 0;
        arr = new int[N];

        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(ss[i]);
            right = Math.max(right,arr[i]);
        }

        int left = 0;

        while(left < right){
            int mid = (left+ right)/2; //mid의 범위 줄이거나 늘려 나가기
            if(solve(mid) <= M){
                //충분하다는 의미 mid값을 더 넓혀봐도 괜찮다는 의미
                right = mid;
            }else{
                //너무 작게 쪼개서 너무 많아 구분되었다는 의미 mid값을 늘릴 필요 있음
                left = mid+1;
            }
        }

        System.out.println(right);

        }

    private static int solve(int mid) {
        int count = 1;

        int min = MIN;
        int max = MAX;

        for(int i =0; i < N; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);

            if(max - min > mid){
                count++;
                //구역 나누고
                max = MAX;
                min = MIN;
                i--;
            }
        }

        return count;
    }

}