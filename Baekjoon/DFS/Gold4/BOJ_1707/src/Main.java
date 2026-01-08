import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K; //테스트 케이스
    static int[] color;
    static ArrayList<ArrayList<Integer>> list;
    static boolean ans;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());


        while (K-- > 0) {
            list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken()); //정점의 개수
            int e = Integer.parseInt(st.nextToken()); //간선의 개수

            for (int i = 0; i <= v; i++) {
                list.add(new ArrayList<>());

            }
            color = new int[v + 1];

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.get(x).add(y);
                list.get(y).add(x);
            }

            ans = true;

            for (int i = 1; i <= v; i++) {
                if (color[i] == 0) {
                    dfs(i, 1);
                }
            }

            if (ans) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    private static void dfs(int i, int c) {
        color[i] = c;
        ArrayList<Integer> next = list.get(i);

        for (int n : next) {
            if (color[n] == c) {
                ans = false;
                return;
            }
            if (color[n] == 0) {
                dfs(n, 3 - c);
            }
        }
    }

}