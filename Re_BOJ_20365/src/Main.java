import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char prev = 'O';

        int Bc = 0;  //B묶음 수
        int Rc = 0;  //R묶음 수

        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);

            if (c == 'B') {
                if (prev != c) {
                    Bc++;

                }
            } else if (c == 'R') {
                if (prev != c) {
                    Rc++;

                }
            }
            prev = c;
        }

        if (Bc >= Rc) {
            System.out.println(Rc + 1);
        } else if (Bc < Rc) {
            System.out.println(1 + Bc);
        }


    }
}