import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_2908_상수_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer reverseA = new StringBuffer(st.nextToken()).reverse();
        StringBuffer reverseB = new StringBuffer(st.nextToken()).reverse();
        int a = Integer.parseInt(reverseA.toString());
        int b = Integer.parseInt(reverseB.toString());
        System.out.println(Math.max(a,b));
    }
}
