import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //6분컷
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int r1= 0; int r2 = 0; int r3 = 0;
        int sum = 0;

        r1 = Integer.parseInt(br.readLine());
        r2 = Integer.parseInt(br.readLine());
        r3 = Integer.parseInt(br.readLine());

        sum = r1 + r2+ r3;

        if(r1 == r2 && r2== r3 && r1 == 60){
            System.out.println("Equilateral");
        }else if(sum == 180 && (r1==r2|| r2==r3 || r1==r3 )){
            System.out.println("Isosceles");
        }else if(sum == 180 && r1 !=r2 && r2!= r3 && r1 != r3){
            System.out.println("Scalene");
        }else if(sum != 180){
            System.out.println("Error");
        }
    }

}