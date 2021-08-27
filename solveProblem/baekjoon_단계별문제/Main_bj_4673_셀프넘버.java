import java.util.Arrays;

public class Main_bj_4673_셀프넘버 {
    public static void main(String[] args) {
        final int N = 10000;
        boolean[] selfNumber = new boolean[N+1];
        Arrays.fill(selfNumber,true);

        int dn, n = 0;
        while(++n < N) if((dn = d(n)) < selfNumber.length) selfNumber[dn] = false;
        for(int i = 1; i < selfNumber.length; i++) if(selfNumber[i]) System.out.println(i);
    }
    private static int d(int n) {
        int sum = n;
        while (n > 0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
}
