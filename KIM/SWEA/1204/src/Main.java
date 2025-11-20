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
            int n = sc.nextInt(); // 테스트 케이스 번호

            int[] cnt = new int [101];
            int max_score = 0;

            for(int i = 0; i < 1000; i++)
            {
                int score = sc.nextInt();
                cnt[score]++;

                if(cnt[score] > cnt[max_score])
                    max_score=score;
                else if(cnt[score] == cnt[max_score])
                    max_score=Math.max(max_score,score);
            }

            System.out.println("#" + n + " " + max_score);



        }
    }
}