import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;


    public static void main(String[] args) throws IOException {
        //병든 나이트
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로길이
        M = Integer.parseInt(st.nextToken()); //가로길이
        int count = 1;
        //세로가 1일 때
        if(N==1){
            count =1;
        }else if(N == 2){
            //세로가 2일때
            count = Math.min(4, (M+1)/2);
        }else if(M < 7){
            //가로가 7보다 작을 때

            count = Math.min(4,M);

        }else if(M >=7){
            //M이 7보다 같거나 클때
            count = M-2;
        }
        System.out.println(count);
    }
}