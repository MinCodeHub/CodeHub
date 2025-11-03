import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collector;

public class Main {
    static int N;
    static int[] arr;
    static int[] freq;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int min = -4001;
        int max = 4001;

        freq = new int[8001];

        int sum = 0;
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(br.readLine());
            sum += v;
            arr[i] = v;
            freq[v + 4000]++;
        }

        //산술 평균
        double avg = (double)sum / N;
        int s = (int) Math.round(avg);
        sb.append(s).append("\n");
        Arrays.sort(arr);

        min = arr[0];
        max = arr[arr.length - 1];
        //System.out.println(min+" "+max);

        //중간값
        int middleValue = N / 2;
        sb.append(arr[middleValue]).append("\n");

        int maxFre = 0;

        for(int f : freq){
            if(maxFre < f){
                maxFre = f;
            }
        }

        int mode = 0;
        boolean firstFound = false;

        for(int i =0; i<freq.length; i++){
            if(freq[i] == maxFre){
                if(!firstFound)
                {
                    firstFound = true;
                    mode = i - 4000;

                }else{
                    mode = i - 4000;
                    break;
                }
            }
        }
        sb.append(mode).append("\n");

        sb.append(max-min).append("\n");
        System.out.println(sb);
    }
}