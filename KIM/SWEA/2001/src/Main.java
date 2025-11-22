import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] mat = new int[N][N];

            for(int i = 0; i < N; i++)
                for(int j = 0; j < N; j++)
                    mat[i][j] = sc.nextInt();

            int max = 0;
            for(int i = 0; i <= N-M; i++)
            {
                for(int j = 0; j <= N-M; j++)
                {
                    int sum = 0;
                    for(int r = i; r < i+M; r++)
                    {
                        for(int c = j; c < j+M; c++)
                            sum += mat[r][c];
                    }

                    if(sum > max)
                        max = sum;
                }
            }
            System.out.println("#" + test_case + " " + max);

        }
    }
}