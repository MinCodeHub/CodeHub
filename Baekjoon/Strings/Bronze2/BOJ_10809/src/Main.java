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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i) - '0')) {
                continue;
            } else {
                map.put(str.charAt(i) - '0', i);
            }
        }

        for (int i = 49; i <= 74; i++) {
            if (map.containsKey(i)) {
                sb.append(map.get(i)).append(" ");
            } else {
                sb.append(-1).append(" ");
            }

        }
        System.out.println(sb);
    }
}