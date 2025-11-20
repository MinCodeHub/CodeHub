import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[][] mat = new int[N][N];
            int score = 0;
            for(int i = 0; i < N; i++)
            {
                String[] arr = sc.next().split("");
                for(int j = 0; j < N; j++)
                    mat[i][j] = Integer.parseInt(arr[j]);
            }

            for(int i = 0; i <= N/2; i++)
            {
                for(int j = 0; j <= i; j++)
                {
                    if(i != N/2)
                    {
                        if(j == 0){
                            score += mat[i][N/2+j];
                            score += mat[N-i-1][N/2+j];
                        }
                        else{
                            score += mat[i][N/2+j];
                            score += mat[i][N/2-j];
                            score += mat[N-i-1][N/2+j];
                            score += mat[N-i-1][N/2-j];
                        }

                    }
                    else
                    {
                        if(j == 0){
                            score += mat[i][N/2+j];
                        }
                        else{
                            score += mat[N-i-1][N/2+j];
                            score += mat[N-i-1][N/2-j];
                        }
                    }

                }
            }

            System.out.println("#" + test_case + " " + score);
        }
    }
}