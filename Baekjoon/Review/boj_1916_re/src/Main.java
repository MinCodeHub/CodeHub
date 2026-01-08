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
            return Integer.compare(this.cost,o.cost);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int n =Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Node>[] graph = new ArrayList[n+1];

        for(int i = 0; i<= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<m; i++){
            st  = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end,cost));
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
            Node now = pq.poll();

            if(now.cost > dist[now.city])
                continue;

            for(Node next: graph[now.city]){
                if(dist[next.city] > dist[now.city]+ next.cost){
                    dist[next.city] = dist[now.city]+ next.cost;
                    pq.offer(new Node(next.city, dist[next.city]));
                }
            }

        }
        System.out.println(dist[end]);
    }
}