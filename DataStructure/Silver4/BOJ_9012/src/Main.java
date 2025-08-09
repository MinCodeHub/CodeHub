import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        Stack<Character> s = new Stack<>();

        for(int i =0; i<N; i++){
            String str = br.readLine();
            char[] c = str.toCharArray();
            s.push(c[0]);
            for(int j = 1; j < c.length; j++){
                if(s.isEmpty()){
                    s.push(c[j]);
                }else if(s.peek() == c[j]){
                    s.push(c[j]);
                }else if(s.peek() == '('){
                    s.pop();
                }else{
                    s.push(c[j]);
                }
            }

            if(!s.isEmpty()){
                sb.append("NO").append("\n");
            }else{
                sb.append("YES").append("\n");
            }
            s.clear();
        }
        System.out.println(sb);
    }
}