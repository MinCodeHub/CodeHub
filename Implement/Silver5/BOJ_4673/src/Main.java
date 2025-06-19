public class Main {
    public static void main(String[] args) {

        boolean[] arr = new boolean[10037];

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= 10000; i++){
            int n = i;
            int tmp = i;

            while( tmp > 0){
                n += tmp%10;
                tmp = tmp/10;
            }
            if(arr[n] == false){
                arr[n] = true;
            }
        }
        for(int i = 1; i <= 10000; i++) {
        if(!arr[i]){
            sb.append(i).append("\n");
        }

        }

        System.out.print(sb);

    }
}