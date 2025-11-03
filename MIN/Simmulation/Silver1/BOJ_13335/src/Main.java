import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] trucks = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }
        Queue<Truck> bridge = new LinkedList<>();

        int time = 0;
        int totalWeight = 0;
        int index = 0;

        while (index < n || !bridge.isEmpty()) {
            time++;
            //다리를 지난 트럭 제거

            if (!bridge.isEmpty() && (time - bridge.peek().enterTime) >= w) {
                Truck out = bridge.poll();
                totalWeight -= out.weight;
            }

            //새로운 트럭 진입 시도
            if (index < n && totalWeight + trucks[index] <= l && bridge.size() < w) {
                bridge.add(new Truck(trucks[index], time));
                totalWeight += trucks[index];
                index++;
            }
        }
        System.out.println(time);
    }
}

class Truck {
    int weight;
    int enterTime; // 다리 위에 들어간 시간

    Truck(int weight, int enterTime) {
        this.weight = weight;
        this.enterTime = enterTime;
    }
}