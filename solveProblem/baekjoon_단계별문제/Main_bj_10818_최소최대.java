import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main_bj_10818_최소최대 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_10818_최소최대.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (n-- > 0) {
            int next = sc.nextInt();
            if(min > next) min = next;
            if(max < next) max = next;
        }

        System.out.println(min + " " + max);
    }
}
