import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_bj_2292_벌집 {
    public static void main(String[] args) throws IOException {
        // N 10억
        // a0 = 2,3,4,5,6,7
        // 1+ a0 + (a0+6) + (a0+6+6) + ... (a0+6*(n-1))
        // 1+ n*a0 + 6*(n*(n-1)/2)
        // 1+ n*a0 + 3n*(n-1)
        // if(a0 == 2) 2n + 3n(n-1) <= N
        // 3n(n-1) = N
        // 3n^2 = N
        // 3n(n+1) = N
        // 3n(n+2) = N
        // 3n(n+3) = N
        // 3n(n+4) = N

        // N = 13
        // N/3 = 4.xx <= n(n-1) 3*2
        // N=58
        // N/3 = 19.xx <= n(n-1) 5*4
        // a = Math.sqrt(N/3) = 4.xx +1
        // N = 1
        // N/3 = 0.xx
        // a = Math.sqrt(0.xx) = 0.xx +1
        // N = 2
        // N/3 = 0.xx
        // a = Math.sqrt(0.xx) = 0.xx +1
        // N = 3
        // N/3 = 1
        // a = Math.sqrt(1) = 1 +1
        // N = 8
        // N/3 = 2.xx
        // a = Math.sqrt(2.xx) = 1.xx +1
        // N = 9
        // N/3 = 3
        // a = Math.sqrt(3) = 1.xx +1

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) +1;
        long a = Math.round(Math.sqrt(N/3)) +1;
        System.out.println(a);

        br.close();
    }
}
