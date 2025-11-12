/*
 * 문제: SWEA 1206. [S/W 문제해결 기본] 1일차 - View
*/

import java.util.Scanner;

public class Main {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int i, cnt = 0;
            int n = sc.nextInt(); //  건물 개수
            int[] list = new int[n+1];

            for(i = 1; i <= n; i++)
            {
                list[i] = sc.nextInt();
            }

            for(i = 3; i <= n-2; i++)
            {
                int max = Math.max(list[i-1], Math.max(list[i-2], Math.max(list[i+1], list[i+2])));
                if(list[i] > max)
                    cnt = cnt + (list[i] - max);
            }

            System.out.println("#" + test_case + " " + cnt);

        }
    }
}

