/*
 * 문제: SWEA 1208. [S/W 문제해결 기본] 1일차 - Flatten
 */

import java.util.Scanner;

public class Main {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int dump = sc.nextInt();
            int[] list = new int[100];
            int max_id = 0;
            int min_id = 0;

            for(int i = 0; i < 100; i++)
            {
                list[i] = sc.nextInt();
                if(list[i] > list[max_id])
                    max_id = i;
                if(list[i] < list[min_id])
                    min_id = i;
            }

            for(int i = 0; i < dump; i++)
            {
                for(int j = 0; j < 100; j++)
                {
                    if(list[j] > list[max_id])
                        max_id = j;
                    if(list[j] < list[min_id])
                        min_id = j;
                }

                if(list[max_id] - list[min_id] <= 1)
                    break;

                list[max_id]--;
                list[min_id]++;

            }

            for(int i = 0; i < 100; i++)
            {
                if(list[i] > list[max_id])
                    max_id = i;
                if(list[i] < list[min_id])
                    min_id = i;
            }

            System.out.println("#" + test_case + " " + (list[max_id] - list[min_id]));
        }
    }
}