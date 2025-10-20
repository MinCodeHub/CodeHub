import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String url = st.nextToken();
            String pwd = st.nextToken();
            map.put(url, pwd);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String url = st.nextToken();
            if (map.containsKey(url)) {
                sb.append(map.get(url)).append("\n");
            }
        }
        System.out.println(sb);
    }
}