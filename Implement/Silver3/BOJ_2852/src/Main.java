import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //NBA 농구

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int team1Score = 0; int team2Score = 0;
        int leadTime1 = 0; int leadTime2 = 0;
        int prevTime = 0;

        for(int i =0; i<N; i++){

            st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            String[] time = st.nextToken().split(":");
            int currentTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

            if(team1Score > team2Score) {
                leadTime1 += currentTime - prevTime;
            }
            else if(team2Score > team1Score){
                leadTime2 += currentTime-prevTime;
            }

            if(team == 1){
                team1Score++;
            }else{
                team2Score++;
            }

            prevTime = currentTime;

        }

        // 마지막 시간 처리
        if(team1Score>team2Score)
            leadTime1+= 2880-prevTime;
        else if(team2Score > team1Score)
            leadTime2+=2880-prevTime;



        System.out.printf("%02d:%02d\n", leadTime1/60, leadTime1%60);
        System.out.printf("%02d:%02d\n", leadTime2/60, leadTime2%60);



    }

}

