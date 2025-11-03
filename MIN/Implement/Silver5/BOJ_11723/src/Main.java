import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            if(str.equals("empty")){
                set.clear();
                continue;
            }else if(str.equals("all")){
                set.clear();
                for(int j =1; j<21; j++){
                    set.add(j);
                }
                continue;
            }
            int num = Integer.parseInt(st.nextToken());

            if(str.equals("add")){
                set.add(num);
            }else if(str.equals("remove")){
                set.remove(num);
            }else if(str.equals("check")){
                if(set.contains(num))
                {
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else if(str.equals("toggle")){
                if(set.contains(num))
                {
                    set.remove(num);
                }else{
                    set.add(num);
                }
            }
        }
        System.out.println(sb);
    }
}