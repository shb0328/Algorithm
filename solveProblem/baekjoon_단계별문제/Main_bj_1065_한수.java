import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_bj_1065_한수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine()); //1000
        int cnt = 0, n = 0;
        while (++n <= N) if(isHansu(n)) cnt++;
        System.out.println(cnt);
        br.close();
    }

    private static boolean isHansu(int n) {
        int prev = n%10;
        n/=10;
        int curr = n%10;
        int diff = curr - prev;

        while ( n > 0 ) {
            if(diff != curr - prev) return false;
            prev = curr;
            n/=10;
            curr = n%10;
        }
        return true;
    }
}
