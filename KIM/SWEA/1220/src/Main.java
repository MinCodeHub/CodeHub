import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[][] mat = new int[N][N];

            for(int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    mat[i][j] = sc.nextInt();

            int w = 0;

            for(int j = 0; j < N; j++)
            {
                for(int i = 0; i < N; i++)
                {
                    if(mat[i][j] == 2)
                    {
                        if(i-1 < 0)
                            mat[i][j] = 0;
                        else if (mat[i-1][j] == 3) {
                            continue;
                        } else if (mat[i-1][j] == 1) {
                            w++;
                            mat[i][j] = 3;
                            mat[i-1][j] = 3;
                        } else if(mat[i-1][j] == 0) {
                            mat[i][j] = 0;
                            mat[i-1][j] = 2;
                        }
                    }
                    else if (mat[i][j] == 1) {
                        if(i+1 >= N)
                        {
                            mat[i][j] = 0;
                        } else if (mat[i+1][j] == 2) {
                            w++;
                            mat[i][j] = 3;
                            mat[i+1][j] = 3;
                        } else if(mat[i+1][j] == 3){
                            continue;
                        } else if (mat[i+1][j] == 0) {
                            mat[i][j] = 0;
                            mat[i+1][j] = 1;
                        }

                    }
                }
            }

            System.out.println("Case #" + test_case + ": " + w);
        }
    }
}