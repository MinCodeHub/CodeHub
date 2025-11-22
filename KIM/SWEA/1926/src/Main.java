import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
//        int T;
//        T=sc.nextInt();
//
//        for(int test_case = 1; test_case <= T; test_case++)
//        {
//        }

        int n = sc.nextInt();

        for(int i = 1; i <= n; i++)
        {
            String[] arr = String.valueOf(i).split("");
            int cnt = 0;
            for(int j = 0; j < arr.length; j++)
            {
                if(arr[j].equals("3") || arr[j].equals("6") || arr[j].equals("9")) {
                    cnt++;
                }
            }

            if(cnt > 0)
            {
                for (int m = 0; m < cnt; m++)
                {
                    System.out.print("-");
                }
            }else {
                System.out.print(i);
            }
            System.out.print(" ");

        }
    }
}