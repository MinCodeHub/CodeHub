import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int H = sc.nextInt();
            int W = sc.nextInt();

            char[][] mat = new char[H][W];
            for(int i = 0; i < H; i++)
            {
                String line = sc.next();
                for(int j = 0; j < W; j++)
                    mat[i][j] = line.charAt(j);
            }

            int cnt = 0;
            boolean black;

            for(int i = 0; i < H; i++)
            {
                black = true;
                for(int j = 0; j < W; j++)
                {
                    if (mat[i][j] != '#') {
                        black = false;
                        break;
                    }

                }
                if(black)
                    cnt++;
            }

            for(int i = 0; i < W; i++)
            {
                black = true;
                for(int j = 0; j < H; j++)
                {
                    if (mat[j][i] != '#') {
                        black = false;
                        break;
                    }

                }
                if(black)
                    cnt++;
            }

            if(cnt == H+W)
                System.out.println(Math.min(H, W));
            else
                System.out.println(cnt);
        }
    }
}
