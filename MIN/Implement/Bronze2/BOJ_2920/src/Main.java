import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr = new int[8];
        st = new StringTokenizer(br.readLine());
        int up =0;
        int down = 0;


        for(int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i > 0) {
                if(arr[i-1] < arr[i]){ //다음이 커지면
                    up++;
                }else{
                    down++;
                }
            }
        }

        if(up!=0 && down!=0){
            System.out.println("mixed");
        }else if(up==0 && down!=0){
            System.out.println("descending");
        }else if(up!=0 && down == 0){
            System.out.println("ascending");
        }

    }
}