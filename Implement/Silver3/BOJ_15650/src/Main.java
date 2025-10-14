import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//조합 문제
public class Main {
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        combination(1,0);
    }

    private static void combination(int start, int depth) {
        if(depth == M ){
            for(int i =0; i<M;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i <= N;i++){
            arr[depth] = i;
            combination(i +1 , depth+1);
        }

    }
}