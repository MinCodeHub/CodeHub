import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] height;
    static int[] result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = new int[N];
        result = new int[N];

        for(int i =0; i<N; i++){
            height[i] = Integer.parseInt(st.nextToken());
        }
        for(int i =0; i<N; i++) { //키 1부터 -> 인덱스는 0부터
            int cnt = 0; //빈 자리 수

            for (int j = 0; j < N; j++) { //자리 잡는 중
                if (result[j] == 0) {
                    if (cnt == height[i]) {
                        result[j] = i + 1;
                        break;
                    }
                    cnt++;
                }
            }
        }

        for(int i = 0; i<N; i++){
            System.out.print(result[i]+" ");
        }

    }
}