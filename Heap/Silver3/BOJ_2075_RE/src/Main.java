import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N= Integer.parseInt(br.readLine());
       // int[][] arr = new int[N][N];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                pq.offer(num);
            }
        }

        for(int i =0; i < N-1; i++){
            pq.poll();
        }
        System.out.println(pq.poll());

    }
}