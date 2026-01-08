import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        HashMap<Integer, Integer> map = new HashMap<>();


        int n = 17;
        // 2~6은 3글자씩
        for (int i = 2; i <= 6; i++) {
            for (int j = 0; j < 3; j++) {
                map.put(n, i);
                n++;
            }
        }
        // 7(PQRS)은 4글자
        for (int j = 0; j < 4; j++) {
            map.put(n, 7);
            n++;
        }
        // 8(TUV)은 3글자
        for (int j = 0; j < 3; j++) {
            map.put(n, 8);
            n++;
        }
        // 9(WXYZ)는 4글자
        for (int j = 0; j < 4; j++) {
            map.put(n, 9);
            n++;
        }
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char cc = str.charAt(i);
            int cs = cc - '0';
            if (map.containsKey(cs)) {
                int num = map.get(cs) + 1;
                sum += num;
            }
        }
        System.out.println(sum);

    }
}