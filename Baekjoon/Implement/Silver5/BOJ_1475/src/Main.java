import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] checknum = new int[11];

        while (N > 0) {
            int n = N % 10;
            checknum[n] += 1;
            N = N / 10;
        }

        int sixNine = (checknum[6] + checknum[9] + 1) / 2;
        checknum[6] = checknum[9] = sixNine;

        int max = 0;

        for (int i = 0; i < 10; i++) {
            if (max < checknum[i]) {
                max = checknum[i];
            }
        }
        System.out.println(max);


    }
}