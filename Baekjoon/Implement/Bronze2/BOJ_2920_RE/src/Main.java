import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        boolean ascending = false;
        boolean mix = false;
        int[] arr = new int[8];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        if (arr[0] < arr[1]) {
            ascending = true;
        } else {
            ascending = false;
        }
        for (int i = 2; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (ascending && arr[i - 1] > arr[i]) { //오름 차순인데 역순되면 mix
                mix = true;
                System.out.println("mixed");
                break;
            } else if (!ascending && arr[i - 1] < arr[i]) {
                //내림차순인데 오름차순이 섞여있으면 믹스
                mix = true;
                System.out.println("mixed");
                break;
            }

        }
        if(ascending && !mix){
            System.out.println("ascending");
        }else if(!ascending && !mix){
            System.out.println("descending");
        }


    }
}