import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> map = new LinkedHashMap();
        for(int i = 0; i<n; i++){
            String s = br.readLine();
            map.put(s,i);
        }

        for(int j = 0; j<m; j++){
            String str = br.readLine();
            String[] ss = str.split(",");
            int len = ss.length;
            for(int k = 0; k<len; k++){
                if(map.containsKey(ss[k])){
                    map.remove(ss[k]);
                }
            }
            System.out.println(map.size());
        }
    }
}