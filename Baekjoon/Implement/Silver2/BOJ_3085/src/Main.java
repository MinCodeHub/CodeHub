import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//브루투포스

public class Main {
    static int N;
    static char[][] map;

    static int max = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        //오른쪽애랑 바꾸기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j, i, j + 1);
                search();
                swap(i, j + 1, i, j); //되돌려주기
            }
        }

        //아래쪽 애랑 바꾸기
        for (int i = 0; i < N - 1;i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j, i+1, j);
                search();
                swap(i+1, j , i, j); //되돌려주기
            }
        }


        System.out.println(max);
        br.close();

    }

    //가장 긴 것 찾기
    private static void search() {

        //오른쪽으로 둘러봤을 때 가장 긴 값 찾기
        for (int i = 0; i < N; i++) {
            int count = 1;

            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] == map[i][j + 1]) {
                    count += 1;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }

        }

        //아래쪽으로 둘러봤을 때 가장 긴 값 찾기
        for (int i = 0; i < N; i++) {
            int count = 1;

            for (int j = 0; j < N - 1; j++) {
                if (map[j][i] == map[j + 1][i]) {
                    count += 1;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }

        }
    }

    private static void swap(int x, int y, int nx, int ny) {
        char tmp = map[x][y];
        map[x][y] = map[nx][ny];
        map[nx][ny] = tmp;

    }
}