import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Node {
    int start;
    int end;
    Node(int start, int end, int cnt) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    static int N;
    static List<Node> list;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list.add(new Node(n1,n2,1));
        }

        //끝나는 시간이 같으면 시작 시간이 작은것을 앞으로
        //시작 시간이 같으면 끝나는 시간이 작은 것을 앞으로
        list.sort((a,b)-> a.end == b.end ? a.start - b.start : a.end - b.end );


        int cnt =0;
        int lastEnd = -1;

        for(Node node: list){
         int n1 = node.start;
         int n2 = node.end;
         //System.out.println("start :"+ n1+" end: "+ n2);
        }
        for(Node node: list){
            if(node.start >= lastEnd ){
                cnt++;
                lastEnd = node.end;
            }
        }

        System.out.println(cnt);

    }
}