import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //예산
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int m;

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];

        int sum = 0;
        int right = 0;

        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            right = Math.max(right, arr[i]);
        }

        m = Integer.parseInt(br.readLine());



        if(sum <= m){
            System.out.println(right);
            return;
        }
        int left = 1;
        int result  = 0;
        while(left <= right){

            int mid = (left + right) / 2;
             sum = 0;

            for(int i =0; i<n; i++){
                if(arr[i] < mid){
                    sum += arr[i];
                }else{
                    sum+=mid;
                }
            }

            if(sum > m){
                right = mid - 1;
            }else{
                left = mid + 1;
                result =mid;
            }

        }

        System.out.println(result);




    }
}