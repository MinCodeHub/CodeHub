import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int len = (int) Math.pow(3, n);
            answer = new StringBuilder();

            for (int i = 0; i < len; i++) {
                answer.append("-");
            }
            func(0, len);//시작 인덱스, 시작길이

            System.out.println(answer);
        }
        sc.close();
    }

    private static void func(int start, int size) {
        if (size == 1) {
            return;
        }
        int newSize = size / 3;

        for (int i = start + newSize; i < start + newSize * 2; i++) {
            answer.setCharAt(i, ' ');
        }
        func(start, newSize);
        func(start + newSize * 2, newSize);
    }
}