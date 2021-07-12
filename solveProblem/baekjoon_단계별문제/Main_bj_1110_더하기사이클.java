import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_bj_1110_더하기사이클 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 1;
        int num = n;
        while((n=func(n)) != num) cnt++;
        System.out.println(cnt);

        br.close();
    }

    private static int func(int num) {
        int a = num%10;
        int b = num/10;
        int sum = a + b;
        int result = a*10 + sum%10;
        return result;
    }
}
