import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean flag = false; //false이면 버리고 true이면 밑으로 뺴기

        Queue<Integer> q = new LinkedList<>();

        for(int i =1; i<=N; i++){
            q.offer(i);
        }

        while(!q.isEmpty()){
            if(q.size()==1){
                System.out.println(q.poll());
                return;
            }
            if(!flag){
                q.poll();
                flag = true;
                continue;
            }
            if(flag){
               int tmp = q.poll();
               q.offer(tmp);
               flag = false;
            }
        }
    }
}