
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int x;
    int y;
    int time;
    int size;
    int fish;

    public Node(int x, int y, int time, int size, int fish) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.size = size;
        this.fish = fish;
    }

    @Override
    public int compareTo(Node o) {
        if (o.time == this.time) {
            if (this.x == o.x) {
                return this.y - o.y; // 열이 작을수록 우선
            } else {
                return this.x - o.x;
            }
        }

        return this.time - o.time;
    }
}

public class Main {
    static PriorityQueue<Node> q = new PriorityQueue<>();
    static int size = 2;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int totalTime = 0; // 정답 시간
    static int sx; //상어 위치
    static int sy; //상어 위치
    static int eaten = 0;//먹은 물고기 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    sx = i;
                    sy = j;
                    arr[i][j] = 0;
                }
            }
        }

        //한 번에 한 마리만 찾는 BFS를 반복
        while (true) {
            int time = bfsOnce(); //가장 가까운 먹이 1마리를 찾아 이동
            if (time == -1) //더 이상 먹을 물고기 없음
                break;
            totalTime += time;
        }
        System.out.println(totalTime);

    }

    //거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
    //거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.

    //PQ를 이용해 현재 상어 위치에서 "가장 가까운 먹이 1마리"를 찾고
    //그 위치로 상어를 이동시키며, 이동거리(시간)을 반환, 없으면 -1
    private static int bfsOnce() {
        q.clear();
        visited = new boolean[N][N];
        q.offer(new Node(sx, sy, 0, size, eaten));
        visited[sx][sy] = true;
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            size = node.size; //상어의 크기
            int time = node.time; //누적 시간

            if (arr[x][y] > 0 && arr[x][y] < size) {
                arr[x][y] = 0;
                sx = x;
                sy = y;
                eaten++;
                if (eaten == size) {
                    size++;
                    eaten = 0;
                }
                return time;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;
                if (visited[nx][ny])
                    continue;

                if (arr[nx][ny] > size)
                    continue;
                visited[nx][ny] = true;
                q.offer(new Node(nx, ny, time + 1, size, eaten));
            }
        }
        return -1;
    }
}