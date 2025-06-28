
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        boolean[] v = new boolean[str.length];

        int k = 0;
        char[] duck = {'q', 'u', 'a', 'c', 'k'};
        int cnt = 0;

        if (str[0] != 'q' || str.length % 5 != 0) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < str.length; i++) {
            ArrayList<Character> list = new ArrayList<>();
            for (int j = i; j < str.length; j++) {
                if (!v[j] && str[j] == duck[k]) {
                    k++;
                    list.add(str[j]);
                    v[j] = true;
                    if (k == 5) {
                        k = 0;
                    }


                }
            }

            if (!list.isEmpty()) {
                if (list.get(list.size() - 1) != 'k') {
                    System.out.println(-1);
                    return;
                }
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}