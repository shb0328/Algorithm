import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_bj_2577_숫자의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int num = a*b*c;
        char[] cNum = Integer.toString(num).toCharArray();

        int[] numCnt = new int[10];
        for (char n : cNum) numCnt[n-'0']++;
        for (int n : numCnt) System.out.println(n);

        br.close();
    }
}
