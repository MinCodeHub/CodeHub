import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static char[][] map; //적록색약이 아닌 사람의 그림
    static boolean[][] visited;
    static char[][] map2; //적록색약인 사람의 그림
    static boolean[][] visited2; //적록색약인 사람의 그림 방문여부

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result1;
    static int result2;

    static Queue<Node> q = new LinkedList<>();

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        map = new char[N][N];
        map2 = new char[N][N];
        visited = new boolean[N][N];
        visited2 = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
                if (str.charAt(j) == 'R') {
                    map2[i][j] = 'G'; //빨간색이면 그냥 다 초록색으로 치환
                } else {
                    map2[i][j] = str.charAt(j);
                }
            }
        }
        result1 = 0;
        result2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    q.offer(new Node(i, j));
                    visited[i][j] = true;
                    bfs();
                    result1++;
                }
            }
        }
        q.clear();
        sb.append(result1).append(" ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited2[i][j]) {
                    q.offer(new Node(i, j));
                    visited2[i][j] = true;
                    bfsMap2();
                    result2++;
                }
            }
        }
        sb.append(result2);

        System.out.println(sb);

    }

    //적록색약
    private static void bfsMap2() {
        while (!q.isEmpty()) {
            Node n = q.poll();
            int x = n.x;
            int y = n.y;

            char c = map2[x][y];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(!visited2[nx][ny] &&  map2[nx][ny] == c){
                        q.offer(new Node(nx, ny));
                        visited2[nx][ny] = true;
                    }

                }
            }
        }

    }

    //적록색약 아님.
    private static void bfs() {
        while (!q.isEmpty()) {
            Node n = q.poll();
            int x = n.x;
            int y = n.y;

            char c = map[x][y];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] &&  map[nx][ny] == c) {
                        q.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }

                }
            }
        }

    }

}