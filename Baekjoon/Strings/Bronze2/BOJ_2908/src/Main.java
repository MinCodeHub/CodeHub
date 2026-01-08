import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int s1 = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        int s2 = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());

        System.out.println(Math.max(s1, s2));
    }
}