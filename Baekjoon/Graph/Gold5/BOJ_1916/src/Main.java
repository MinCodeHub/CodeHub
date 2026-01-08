import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int city;
        int cost;

        public Node(int city, int cost){
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.cost, o.cost);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); //도시의 개수
        int m = Integer.parseInt(br.readLine()); //버스의 개수

        List<Node>[] graph = new ArrayList[n+1];

        for(int i = 0; i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to  = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to,cost));
        }
        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        //다익스트라
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){
            Node now = pq.poll(); //현재 가장 비용이 적은 노드 꺼내기

            if(now.cost > dist[now.city]) continue; //이미 더 적은 비용으로 도착한 적이 있다면 스킵

            for(Node next: graph[now.city]){
                //현재 노드를 통해 가는 것이 더 저렵하면 업데이트
                if(dist[next.city] > dist[now.city]+next.cost){
                    dist[next.city] = dist[now.city]+ next.cost;
                    pq.offer(new Node(next.city, dist[next.city]));
                }
            }
        }
        System.out.println(dist[end]);
    }
}