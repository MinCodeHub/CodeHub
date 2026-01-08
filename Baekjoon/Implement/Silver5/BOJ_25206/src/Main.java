import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Double sum = 0.0; //학점의 총합
        Double ssum = 0.0;  //학점 * 과목평점 의 총합
        StringTokenizer st;
        for(int i = 0; i<20; i++){
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double grade = Double.parseDouble(st.nextToken());
            String avg = st.nextToken();
            Double avgd = 0.0;

            if(avg.equals("A+")){
                avgd = 4.5;
            }else if(avg.equals("A0")){
                avgd = 4.0;
            }else if(avg.equals("B+")){
                avgd = 3.5;
            }else if(avg.equals("B0")){
                avgd = 3.0;
            }else if(avg.equals("C+")){
                avgd = 2.5;
            }else if(avg.equals("C0")){
                avgd = 2.0;
            }else if(avg.equals("D+")){
                avgd = 1.5;
            }else if(avg.equals("D0")){
                avgd = 1.0;
            }else if(avg.equals("F")){
                avgd = 0.0;
            }else if(avg.equals("P")){
                avgd = 0.0;
            }

            if(!avg.equals("P")){
                sum+=grade; //학점 총 합 계산
                ssum+= (grade * avgd);
            }
        }

        System.out.printf("%4f",(ssum / sum));
    }
}