import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Node {
    int end;
    int cost;

    Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
}

public class Main {
    static int T, N, M, W;
    static List<ArrayList<Node>> graph;
    static int[] dist;
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            dist = new int[N + 1];
            graph = new ArrayList<>();

            for (int j = 0; j <= N; j++) {
                graph.add(new ArrayList<>());
            }
            //방향이 없는 그래프
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph.get(v1).add(new Node(v2, cost));
                graph.get(v2).add(new Node(v1, cost));
            }

            for (int j = 0; j < W; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                cost *= -1;
                graph.get(start).add(new Node(end, cost));
            }

            boolean isMinusCycle = false;

            //모든 정점 체크
            for (int k = 1; k <= N; k++) {
                if (bellmanFord(k)) { //반환이 true라면 음수사이클이 존재한다는 의미
                    isMinusCycle = true;
                    sb.append("YES").append('\n');
                    break;
                }
            }

            if(!isMinusCycle){
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    //벨만포드 알고리즘
    public static boolean bellmanFord(int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0; //시작점은 0으로 초기화

        //정점의 개수 - 1번 동안 최단거리 초기화 작업 반복
        boolean update = false;

        for (int i = 1; i < N; i++) {
            update = false;

            //최단거리 초기화
            for (int j = 1; j <= N; j++) {
                for (Node node : graph.get(j)) {
                   if(dist[j] !=INF && dist[node.end] > dist[j]+node.cost){
                       dist[node.end]  = dist[j] + node.cost;
                       update = true;
                   }
                }
            }
            // 한 번의 반복에서 단 한 번도 업데이트가 일어나지 않았다면
            //이미 최단 거리가 모두 확정된 상태
            if(!update){
                break;
            }
        }

        //근데 만약에 n-1까지 검사를 했는데 update가 true이면 음수 간선이 있을 수 있다는 것
        // 그러면 한번 더 체크
        //음수 사이클 탐지
        if(update){
            for(int i =1; i<=N; i++){
                for(Node node: graph.get(i)){
                    if(dist[i] != INF && dist[node.end] > dist[i]+node.cost){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}