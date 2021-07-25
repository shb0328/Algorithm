import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_1546_평균 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double sum = 0, m = 0;
        int cnt = 0;
        while(cnt++ < n) {
            int a = Integer.parseInt(st.nextToken());
            sum += a;
            m = Math.max(m, a);
        }
        System.out.println(sum / m * 100 / n);
        br.close();
    }
}
