import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Road{
    int start,end,distance;
    public Road(int s, int e, int d){
        this.start=s;
        this.end = e;
        this.distance = d;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[] distance = new int[D+1];
        Arrays.fill(distance,10001);
        List<Road> road = new ArrayList<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if(e > D ||  e-s <= d){
                continue;
            }
            road.add(new Road(s,e,d));
        }

        road.sort(new Comparator<Road>(){
            @Override
            public int compare(Road o1, Road o2){
                if(o1.start == o2.start){
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });

        int arrayIdx = 0;       // 지름길 리스트 인덱스
        int location = 0;       // 현재 위치
        distance[0] = 0;        // 시작점까지는 거리 0

        while(location < D){
            //지름길이 남이있고, 현재 위치에서 시작하는 지름길이 있다면
            if(arrayIdx < road.size()){
                Road r = road.get(arrayIdx);

                if(r.start == location){
                    //해당 지름길을 사용하는 경우와 사용하지 않는 경우 중 최소 선택
                    distance[r.end] = Math.min(distance[r.end],distance[location]+ r.distance);
                    arrayIdx++;
                    continue;


                }
            }

            //일반 도로로 한 칸 이동(1 거리)
            distance[location+1] = Math.min(distance[location+1], distance[location]+1);
            location++;
        }
        System.out.println(distance[D]);
    }
}