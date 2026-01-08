import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    //단어 뒤집기2
    // <가 나타났을 때 이전에 태그가 있었다면 스택이 비어있지 않으면 꺼내야한다.

    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        boolean tag = false;

        for(int i =0; i<s.length(); i++){

            if(s.charAt(i) == '<'){
                tag = true;
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }
            if(s.charAt(i) == '>'){
                sb.append('>');
                tag = false;
                continue;
            }
            if(tag){ //태그 안에 있는 문자라면
                sb.append(s.charAt(i));
            }else{
                //태그 안에있는 문자가 아니라면 거꾸로 출력해야함.
                if(s.charAt(i)!=' '){
                    stack.push(s.charAt(i));
                }else if(s.charAt(i) == ' '){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                }
            }
        }

        if(!stack.isEmpty()){
            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }
        }
        System.out.println(sb);

    }
}