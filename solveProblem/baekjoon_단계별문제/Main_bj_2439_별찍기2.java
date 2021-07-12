import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_bj_2439_별찍기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i); j++) sb.append(' ');
            for (int k = 1; k <= i; k++) sb.append('*');
            if(i != n) sb.append('\n');
        }
        System.out.println(sb.toString());
        br.close();
    }
}
