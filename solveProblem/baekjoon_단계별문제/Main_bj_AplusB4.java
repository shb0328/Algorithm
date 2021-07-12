import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_bj_AplusBminus4 {
    // NullPointer 에러
    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                if(!st.hasMoreTokens()) return;
                System.out.println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
        }
    }
    */

    // 맞았습니다
    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            System.out.println(sc.nextInt() + sc.nextInt());
        }
    }
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int a = str.charAt(0) - '0';
            int b = str.charAt(2) - '0';
            System.out.println(a+b);
        }
    }
}
