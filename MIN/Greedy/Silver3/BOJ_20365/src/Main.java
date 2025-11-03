import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //블로그2
    static int N;
    static char[] map;

    static int cnt;

    public static void main(String[] args) throws IOException {


        // 메모리 측정 시작
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long beforeUsedMem = runtime.totalMemory() - runtime.freeMemory();

        // 시간 측정 시작
        long start = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int BCnt = 0;
        int RCnt = 0;
        int cnt  = 0;
        map = new char[N];

        for(int i=0; i<N; i++){
            map[i] = str.charAt(i);
        }
        char prev ='O';

            for(int j = 0; j < N; j++){
                if(map[j] == 'R'){
                    if(!(prev == map[j])){
                        RCnt++;
                        prev = map[j];
                    }
                }else{
                    if(!(prev == map[j])){
                        BCnt++;
                        prev = map[j];
                    }
                }
            }

            if(RCnt > BCnt){
                System.out.println(BCnt+1);
            }else{
                System.out.println(RCnt+1);
            }

        // 시간 측정 끝
        long end = System.currentTimeMillis();
        System.out.println("실행 시간: " + (end - start) + "ms");

        // 메모리 측정 끝
        long afterUsedMem = runtime.totalMemory() - runtime.freeMemory();
        long usedMem = afterUsedMem - beforeUsedMem;
        System.out.println("사용 메모리: " + (usedMem / 1024) + "KB");




    }
}