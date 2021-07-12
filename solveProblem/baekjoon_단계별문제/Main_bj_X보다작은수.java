import java.io.IOException;
import java.util.Scanner;

public class Main_bj_X보다작은수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int x = sc.nextInt();

        int a;
        for (int i = 0; i < n; i++) {
            if( x > (a = sc.nextInt()) ) sb.append(a).append(' ');
        }

        System.out.println(sb.toString());
        sc.close();
    }
}
