import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Integer> q = new LinkedList<>();
    static int N;
    static int K;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i =0; i<N; i++){
            q.offer(i+1);
        };

        int cnt = 1;
        sb.append("<");
        while(!q.isEmpty()){
            int qq = q.poll();
            if(cnt % K  == 0 ){
                if(q.size()!=0){
                    sb.append(qq).append(", ");
                    cnt++;
                }else{
                    sb.append(qq).append(">");
                    cnt++;
                }
            }else{
                cnt++;
                q.offer(qq);
            }
        }
    System.out.println(sb);
    }


}