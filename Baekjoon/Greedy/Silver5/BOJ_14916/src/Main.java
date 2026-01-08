import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
//그리디 거스름돈
    static int N;

    public static void main(String[] args) throws IOException {
        //춘향이는 편의점 카운터에서 일함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int count = 0;


        //만약에 5의 배수라면
        while(true){
           if(N % 5 == 0){
               count += N/5;
               System.out.println(count);
               break;
           }else{
               count+=1;
               N-=2;
           }

           if(N < 0){
               System.out.println(-1);
               break;
           }
        }
    }
}