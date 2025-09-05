import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int t;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            cnt = 1;
            int result = isPalindrome(str);
            System.out.println(result + " "+ cnt);

        }

    }

    private static int isPalindrome(String str) {
        char[] c = str.toCharArray();
        return recursion(c, 0, str.length() - 1);
    }

    private static int recursion(char[] c, int i, int length) {
        if (i >= length) {
            return 1;
        } else if (c[i] != c[length]) {
            return 0;
        } else {
            cnt++;
            return recursion(c, i + 1, length - 1);
        }
    }
}