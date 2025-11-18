import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[] arr = new int[N];

            for(int i = 0; i < N; i++)
                arr[i] = sc.nextInt();

            int money = 0;
            int max = arr[N-1];

            for(int i = N - 2; i >= 0; i--)
            {
                if(arr[i] < max)
                {
                    money += (max - arr[i]);
                }
                else
                {
                    max = arr[i];
                }
            }

            System.out.println("#" + test_case + " " + money);
        }
    }
}