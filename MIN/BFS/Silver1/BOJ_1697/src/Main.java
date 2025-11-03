import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Sumba {
    int curposition;
    int time;

    Sumba(int cur, int time) {
        this.curposition = cur;
        this.time = time;
    }
}

public class Main {
    static int N;
    static int K;
    static int[] dx = {-1, 1, 2};
    static Queue<Sumba> q = new LinkedList<>();
    static int MAX = 200000;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[MAX + 1];

        if (N == K) { //만약에 이미 같다면
            System.out.println(0);
            return;
        }
        // 시작 노드: 자기 자신, 시간 0
        q.offer(new Sumba(N, 0));
        visited[N] = true;


        bfs();

    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Sumba s = q.poll();
            int cur = s.curposition; //현재 위치
            int time = s.time; //time

            if (cur == K) {
                System.out.println(time); //가장 빨리 발견되는애가 가장 짧은 시간아닌가?
                return;
            }
            int[] nexts = {cur - 1, cur + 1, cur * 2};

            for (int nx : nexts) {
                if (nx < 0 || nx > MAX)
                    continue;

                if (visited[nx]) {
                    continue;
                }

                if (nx == K) {
                    System.out.println(time + 1);
                    return;
                }

                visited[nx] = true;
                q.offer(new Sumba(nx, time + 1));
            }

        }
    }


}