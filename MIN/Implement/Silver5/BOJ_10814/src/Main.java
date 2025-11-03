import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Member implements Comparable<Member>{
    int age;
    String name;
    int order;

    public Member(int age,String name,int order){
        this.age=age;
        this.name=name;
        this.order = order;
    }
    @Override
    public int compareTo(Member o){
        if(this.age == o.age){
            return this.order - o.order;
        }
        return this.age-o.age;
    }
}
public class Main {
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Member> pq = new PriorityQueue<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            Member m = new Member(age,name,i);
            pq.offer(m);
        }
        while(!pq.isEmpty()){
            Member m =  pq.poll();
            System.out.println(m.age+" "+m.name);
        }
    }
}