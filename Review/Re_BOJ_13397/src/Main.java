import com.sun.jdi.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        int max = 0;
        arr = new int[N];
        int mid = 0;

        int left = 0;
        int right = 0;

        for (int i = 0; i < N; i++) {
           arr[i] = Integer.parseInt(ss[i]);
            right = Math.max(right, arr[i]);
        }


        while(left < right){
            mid = (right + left) / 2;
            if(solve(mid) <= M){
                //나눠진 구간 수가  M 이하라면 더 작은건 없는지 찾아보기
                right = mid;
            }else{
                left= mid+1;
            }
        }

        System.out.println(right);
    }

    //구간 나누기
    private static int solve(int mid) {
        int count = 1;
        int max = MAX;
        int min = MIN;

        for(int i = 0; i < N; i++){

            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);

            if(max - min > mid){
                count++;
                max = MAX;
                min = MIN;
                i--;
            }

        }

        return count;
    }
}