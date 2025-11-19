import java.util.Scanner;

public class Main {
    static int n;
    static int[] mat;
    static int cnt;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = sc.nextInt();

            mat = new int[n];
            cnt = 0;

            dfs(0);
            System.out.println("#" + test_case + " " + cnt);
        }
    }

    static void dfs(int col)
    {
        if(col == n)
        {
            cnt++;
            return;
        }

        for(int i = 0; i < n; i++)
        {
            mat[col] = i;
            if(isVaild(col))
                dfs(col+1);
        }
    }

    static boolean isVaild(int c)
    {
        for(int i = 0; i < c; i++)
        {
            if(mat[c] == mat[i])
                return false;
            else if(Math.abs(mat[c] - mat[i]) == Math.abs(c - i))
                return false;
        }
        return true;
    }
}