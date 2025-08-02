import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        boolean found = false; //머리찾으면
        int heartx = 0; //심장의 x좌표
        int hearty = 0; //심장의 y좌표


        char[][] map = new char[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = str.charAt(j - 1);
                if (map[i][j] == '*') {
                    if (!found) {
                        //아직 머리 못찾았다면
                        heartx = i+1;
                        hearty = j;
                        found = true;
                    }
                }
            }
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i <= N; i++) {
            if (i < hearty) {
                if (map[heartx][i] == '*') {
                    left++;
                }
            } else if (i > hearty) {
                if (map[heartx][i] == '*') {
                    right++;
                }
            }

        }
        int mid = 0;

        int leftleg = 0;
        int rightleg = 0;
        int temp =0;
        for (int i = heartx + 1; i <= N; i++) {
            if (map[i][hearty] == '*') {
                mid++;
            } else {
                temp = i;
                break;
            }
        }
        for (int j = temp; j <= N; j++) {
            if (map[j][hearty - 1] == '*') {
                leftleg++;
            }
            if (map[j][hearty + 1] == '*') {
                rightleg++;
            }
        }

        System.out.println(heartx + " " + hearty);
        System.out.println(left + " " + right + " " + mid + " " + leftleg + " " + rightleg);

    }

}