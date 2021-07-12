import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_2908_상수_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int ra = ((a % 10) / 1) * 100 + ((a % 100) / 10) * 10 + (a / 100) * 1;
        int rb = ((b % 10) / 1) * 100 + ((b % 100) / 10) * 10 + (b / 100) * 1;
        System.out.println(ra > rb ? ra : rb);
    }
}
