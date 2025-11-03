import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //회전초밥
    //매상올리기 -> 행사 2개 시행
    //1. 마음대로 초밥을 고르고 먹은만큼 식대 계산
    //but, 벨트의 임의의 한 위치부터 K개의 접시를 연속해서 먹을 시 할인된 정액가격으로 제공
    //2. 각 고객에게 초밥의 종류하나가 쓰인 쿠폰을 발행하고, 1번 행사에 참가할 경우 이 쿠폰에 적혀진 종류의 초밥 하나를 추가로 무료로 제공
    // 만약 번호에 적인 초밥이 현재 벨트 위에 없을 경우, 요리사가 새로 만들어 제공

    static int N;
    static int d;
    static int k;
    static int c;

    static int[] belt; //벨트 위 초밥들
    static int[] count; //현재 창에 각 초밥이 몇 개 있는지
    static int kinds;  //현재 창에 존재하는 서로 다른 초밥의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 벨트 위 접시 수
        d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        count = new int[d+1];
        kinds = 0;
        belt = new int[N];

        // 1. 처음 N개 넣기
        for(int i = 0; i<N; i++){
            belt[i] = Integer.parseInt(br.readLine());
        }

        for(int i =0; i<k; i++){
            if(count[belt[i]] == 0){
                kinds++;
            }
            count[belt[i]]++;
        }
        int answer = bestWithCoupon();


        for(int i =1; i<N; i++){
            int outIdx = belt[i - 1];
            int inIdx = belt[(i + k -1) % N]; //새로 들어올 오른쪽
            remove(outIdx);
            if(count[inIdx]==0) {
                kinds++;
            }
            count[inIdx]++;

            answer = Math.max(answer, bestWithCoupon());
        }

        System.out.println(answer);
    }

    // 창에 있는 곳에서 밀린 거 뺴기
    private static void remove(int outIdx) {
        count[outIdx]-=1;
        if(count[outIdx]==0){
            kinds--;
        }
    }

    //쿠폰까지 사용했을 때 현재 최댓값
    private static int bestWithCoupon() {
        //쿠폰 초밥이 창에 없으면 + 1
        return kinds+(count[c]==0 ? 1 : 0);
    }


}