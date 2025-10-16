import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Node implements Comparable<Node>{
    int end;
    int cost;

    Node(int end, int cost){
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}
public class Main {
    static int n,e;
    static int v1,v2;
    static List<ArrayList<Node>> graph;
    static int[] dist;
    static boolean[] visited;
    static final int INF = 200000000;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        dist = new int[n+1];
        visited = new boolean[n+1];

        graph = new ArrayList<>();

        for(int i =0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b=  Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }
        st = new StringTokenizer(br.readLine());

        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        //1->v1->v2->n
        int res1 = 0;
        res1 += dijkstra(1,v1);
        res1 += dijkstra(v1,v2);
        res1 += dijkstra(v2,n);
        //1->v2->v1->n
        int res2 = 0;
        res2 += dijkstra(1,v1);
        res2 += dijkstra(v1,v2);
        res2 += dijkstra(v2,n);

       int result = (res1 >= INF && res2 >= INF)? -1 : Math.min(res1,res2);
       System.out.println(result);
    }

    private static int dijkstra(int start, int end) {

        Arrays.fill(dist,INF);
        Arrays.fill(visited,false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node node =pq.poll();
            int cur = node.end;

            if(!visited[cur]){
                visited[cur] = true;

                for(Node no: graph.get(cur)){
                    if(!visited[no.end] && dist[no.end] > dist[cur]+ no.cost ){
                        dist[no.end] = dist[cur] + no.cost;
                        pq.offer(new Node(no.end, dist[no.end] ));
                    }
                }
            }
        }
        return dist[end];

    }
}