import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main_bj_10818_최소최대_2 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_10818_최소최대.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int num = 0;
        int sign = 1;

        for (int c : br.readLine().getBytes()) {
            if(c == ' ') {
                num *= sign;
                min = Math.min(min, num);
                max = Math.max(max, num);
                num = 0;
                sign = 1;
            }else if(c == '-') {
                sign = -1;
            }else if('0' <= c && c <= '9') {
                num = num * 10 + (c - '0');
            }
        }

        num *= sign;
        min = Math.min(min, num);
        max = Math.max(max, num);

        System.out.println(min + " " + max);

        br.close();
    }
}
