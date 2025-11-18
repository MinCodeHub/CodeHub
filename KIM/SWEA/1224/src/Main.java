import java.util.*;

public class Main {
    static int cnt;
    static String[] list;
    static int max;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String input = sc.next();
            list = input.split("");
            cnt = sc.nextInt();

            visited = new boolean[1000000][cnt + 1];
            max = 0;
            dfs(0);

            System.out.println("#" + test_case + " " + max);

        }
    }

    static void dfs(int depth)
    {
        int num= Integer.parseInt(String.join("", list));
        if(depth == cnt)
        {
            if(num > max)
                max = num;
            return;
        }

        if(visited[num][depth])
            return;

        visited[num][depth] = true;

        for(int i = 0; i < list.length-1; i++)
        {
            for(int j = i+1; j < list.length; j++)
            {
                String temp = list[i];
                list[i] = list[j];
                list[j] = temp;

                dfs(depth+1);

                temp = list[j];
                list[j] = list[i];
                list[i] = temp;
            }
        }
    }
}