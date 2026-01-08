import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][]map;
    static int result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[101][101];
        result = 0;

        for(int i =0; i< N;i++){
            st = new StringTokenizer(br.readLine());
            int leftx = Integer.parseInt(st.nextToken());
            int lefty = Integer.parseInt(st.nextToken());
            int rightx = Integer.parseInt(st.nextToken());
            int righty = Integer.parseInt(st.nextToken());

        for(int j = lefty; j <=righty; j++){
            for(int k = leftx; k <= rightx;k++){
                map[k][j]+=1;
            }
            }
        }

        for(int i = 1; i<101; i++){
            for(int j = 1; j<101; j++){
                if(map[j][i] > M){
                   result++;
                }
            }
        }
        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();

    }


}