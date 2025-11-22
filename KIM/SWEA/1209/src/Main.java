import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int t = sc.nextInt();
            int[][] mat = new int[100][100];
            for(int i = 0; i < 100; i++)
                for(int j = 0; j < 100; j++)
                    mat[i][j] = sc.nextInt();

            Integer max = 0;
            Integer sum3 = 0, sum4 = 0;
            for(int i = 0; i < 100; i++)
            {
                int sum1 = 0, sum2 = 0;
                for(int j = 0; j < 100; j++)
                {
                    sum1 += mat[i][j];
                    sum2 += mat[j][i];
                }
                max = Math.max(sum1, Math.max(sum2, max));
                sum3 += mat[i][i];
                sum4 += mat[i][99-i];
            }
            max = Math.max(sum3, Math.max(sum4, max));
            System.out.println("#" + test_case + " " + max);
        }
    }
}