import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int leadTeam1Time;
    static int leadTeam2Time;
    static int team1Score;
    static int team2Score;
    static int prev;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        team1Score = 0;
        team2Score = 0;
        leadTeam1Time = 0;
        leadTeam2Time = 0;
        prev = 0;

        int t;
        int mm;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());

            String[] s = st.nextToken().split(":");

            int m = Integer.parseInt(s[0]);
            int se = Integer.parseInt(s[1]);

            mm = m * 60 + se;
            //이전 시간 저장

            if (team1Score > team2Score) {
                leadTeam1Time += mm - prev;
            } else if (team2Score > team1Score) {
                leadTeam2Time += mm - prev;
            }
            prev = mm;
            if (t == 1) {
                team1Score++;
            } else {
                team2Score++;
            }
        }

        if (team1Score > team2Score) {
            leadTeam1Time += 2880 - prev;
        } else if (team2Score > team1Score) {
            leadTeam2Time += 2880 - prev;
        }

        System.out.printf("%02d:%02d\n", leadTeam1Time / 60, leadTeam1Time % 60);
        System.out.printf("%02d:%02d\n", leadTeam2Time / 60, leadTeam2Time % 60);

    }
}