import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[] printArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr = new int[N];
        printArr  = new int[M];
        st = new StringTokenizer(br.readLine());

        for(int i =0; i<N; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        combination(0,0);



    }

    private static void combination(int start, int depth) {

        if(depth == M){
            for(int i=0; i<M;i++){
                System.out.print(printArr[i]+" ");
            }
             System.out.println();
            return;
        }
        int before = -1;

        for(int i = start;i<N;i++){
            int now = arr[i];
            if(before != now){
                before = now;
                printArr[depth] = arr[i];
                combination(i,depth+1);
            }
        }
    }
}