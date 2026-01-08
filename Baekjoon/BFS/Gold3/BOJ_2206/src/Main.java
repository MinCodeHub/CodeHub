import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2차배열을 사용하여 큐에 저장 및 삭제 하면서 노드를 방문하는 방식으로 풀이했었다.
 * dfs백트래킹을 통해서 벽을 부수고 bfs방식으로 거리를 계산하는 방식으로 풀이했었다.
 * 벽을 부수지 않고 가는 방법 방문 2차배열 하나와
 * 벽을 부수고 가는 방법의 방문 2차배열을 따로 만들어주는 식으로 풀이했었다.
 * 그러나 시간 초과가 떴고 3차배열로 풀어야한다는 것을 알게되었다.*/

/*
* 해당 방법이 시간초과가 났던 이유: 벽 하나를 선택해 부수고 매번 bfs를 다시 돌리면
* 벽의 개수를 w개라할 때 O(w*n*m) 최악에서는 O((n*m)^2)까지 커져서 시간초과가 난다 */


public class Main {
    static int n;
    static int m;

    static int[][] map;

    static class Node {
        int w; //벽을 부순건지
        int x;
        int y;

        Node(int w, int x, int y) {
            this.w = w;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];


        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        //출발지와 목적지가 같을 경우
        if (n == 1 && m == 1) {
            System.out.println(1);
            return;
        }

        System.out.println(bfs());

    }

    private static int bfs() {
        // 방문을 체크하는 3차원 배열
        int[][][] check = new int[2][n][m];
// [0, n, m] : 벽 안부수고 지나가는 방문노드 경로
        // [1, n, m] : 벽 부수고 지나가는 방문노드 경로

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0));
        check[0][0][0] = 1;

        while (!q.isEmpty()) {
            Node no = q.poll();
            int w = no.w;
            int x = no.x;
            int y = no.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= n || nx < 0 || ny < 0 || ny >= m) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    if (check[w][nx][ny] == 0) {
                        q.offer(new Node(w, nx, ny));
                        check[w][nx][ny] = check[w][x][y] + 1;

                        if (nx == n - 1 && ny == m - 1) {
                            return check[w][nx][ny];
                        }
                    }

                } else {
                    //다음 노드가 벽일 때 ->1 . w가 1보다 큰 범위를 벗어나게 생겼다면
                    //방문체크와 큐에 넣는 것을 제외하도록 하고,
                    //2. 벗어나지 않는다면 w+1에다가 방문체크하고 큐에 넣을 것.

                    if (w == 0) {
                        if (check[1][nx][ny] == 0) {
                            q.offer(new Node(1, nx, ny));
                            check[1][nx][ny] = check[0][x][y] + 1;
                            if (nx == n - 1 && ny == m - 1) {
                                return check[1][nx][ny];
                            }
                        }
                    }
                }
            }

        }
        return -1;
    }
}