import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int count = 0;

        while(N > 0){
            if(N % 5 == 0){   //N이 5의 배수라면
                count += (N / 5);
                N = 0;
            }else{
                N = N-3; //3을 뺀다
                count +=1;
            }
        }
        if(N < 0){
            System.out.println(-1);
        }else{
            System.out.println(count);

        }

    }
}