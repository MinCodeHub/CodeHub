import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Node {
    int end;
    int cost;
    Node(int end, int cost){
        this.end = end;
        this.cost = cost;
    }
}
public class Main {
    static int N, M;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static long[] dist;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        //리스트 초기화
        list = new ArrayList<>();
        for(int i =0; i<=N; i++){
            list.add(new ArrayList<>());
        }
        dist = new long[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list.get(A).add(new Node(B,C));
        }


        if(bellmanFord(1)){
            //음수 사이클 없으면 결과 출력
            for(int i = 2; i<=N; i++){
                if(dist[i] == INF){
                    System.out.println(-1);
                }else{
                    System.out.println(dist[i]);
                }

            }
        }else{
            System.out.println("-1");
        }
    }

    //벨만 포드
    private static boolean bellmanFord(int start) {
        Arrays.fill(dist,INF);
        dist[start] = 0;


        //N-1번 반복해서 거리 갱신
        for(int i = 1; i< N; i++){
            for(int u = 1; u<=N; u++){
                for(Node node: list.get(u)){
                    int v = node.end;
                    int cost = node.cost;

                    if(dist[u] !=INF && dist[v] > dist[u] + cost){
                        dist[v] = dist[u] + cost;
                    }
                }
            }
        }

        //N번째 체크 -> 음수 사이클 체킹
        for(int u = 1; u<=N; u++){
            for(Node node: list.get(u)){
                int v = node.end;
                int cost = node.cost;

                if(dist[u] != INF && dist[v] > dist[u]+cost){
                    return false;
                }
            }
        }
        return true;


    }
}