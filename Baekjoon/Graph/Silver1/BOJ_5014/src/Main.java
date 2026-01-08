import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int f;
    static int s;
    static int g;
    static int u;
    static int d;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken()); //u만큼 위로
        d = Integer.parseInt(st.nextToken()); //d만큼 아래로

        visited = new boolean[f + 1];


        int result = bfs();
        if (result == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);
        }
    }

    private static Integer bfs() {
        Queue<Stair> q = new LinkedList<>();
        q.offer(new Stair(s, 0));
        visited[s] = true;

        while (!q.isEmpty()) {
            Stair now = q.poll();
            if (now.cur == g) {
                return now.cnt;
            }

            int up = now.cur + u;
            if (up <= f && !visited[up]) {
                q.offer(new Stair(up, now.cnt + 1));
                visited[up] = true;
            }
            int down = now.cur - d;
            if (down > 0 && !visited[down]) {
                q.offer(new Stair(down, now.cnt + 1));
                visited[down] = true;
            }


        }
        return -1;
    }

}

class Stair {
    int cur;
    int cnt;

    Stair(int cur, int cnt) {
        this.cur = cur;
        this.cnt = cnt;
    }
}