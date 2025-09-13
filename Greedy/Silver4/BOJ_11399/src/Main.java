import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    static int N;
    static int[]arr;
    static int[]tmp;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tmp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =0; i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //정렬 작은 수 먼저
        Arrays.sort(arr);
        tmp[0] = arr[0];
        result+=tmp[0];
        for(int i =1; i < N; i++){
            tmp[i] = tmp[i-1]+arr[i];
            result += tmp[i];
        }
        System.out.println(result);

    }
}