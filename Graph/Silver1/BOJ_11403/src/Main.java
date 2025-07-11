import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    //ArrayList안에 ArrayList
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int N;
    static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        answer = new int[N][N];
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bfs(i, j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }

    }

    private static void bfs(int i, int j) {//i에서 j까지 가야함. j가 목적지
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N];

        q.add(i);
        while (!q.isEmpty()) {
            int qq = q.poll();

            for (int next : graph.get(qq)) {
                if (!visited[next]) {
                    visited[next] = true;
                    answer[i][next] = 1;
                    q.add(next);
                }
            }
        }

    }
}