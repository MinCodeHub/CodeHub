/*
 * 문제: SWEA 1249. [S/W 문제해결 응용] 4일차 - 보급로
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class Node{
        int x, y, weight;

        public Node(int x, int y, int weight){
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    public static void main(String args[])
    {


        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {


            int N = sc.nextInt();
            sc.nextLine();
            int[][] mat = new int[N][N];
            int[][] dist = new int[N][N];

            for(int i = 0; i < N; i++)
                Arrays.fill(dist[i], Integer.MAX_VALUE);

            for(int i = 0; i < N; i++) {
                String data = sc.nextLine();
                for(int j = 0; j < N; j++) {
                    mat[i][j] = data.charAt(j) - '0';
                }
            }

            PriorityQueue<Node> queue = new PriorityQueue<>(
                    Comparator.comparingInt(Node->Node.weight)
            );

            queue.offer(new Node(0, 0, 0));
            dist[0][0] = 0;

            int[] n_x = {0, -1, 0, 1};
            int[] n_y = {-1, 0, 1, 0};
            int x, y, new_weight;

            while(!queue.isEmpty()){
                Node node = queue.poll();

                if(node.weight > dist[node.x][node.y]){
                    continue;
                }

                for(int i = 0; i < 4; i++)
                {
                    x = node.x + n_x[i];
                    y = node.y + n_y[i];

                    if(x >= 0 && x < N && y >= 0 && y < N)
                    {
                        new_weight = node.weight + mat[x][y];
                        if(new_weight < dist[x][y])
                        {
                            dist[x][y] = new_weight;
                            queue.offer(new Node(x, y, new_weight));
                        }

                    }
                }
            }

            System.out.println("Case #"+test_case+": "+dist[N-1][N-1]);


        }
    }
}