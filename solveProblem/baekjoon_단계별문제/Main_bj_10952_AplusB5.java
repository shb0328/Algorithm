import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_10952_AplusB5 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("solveproblem/res/Main_bj_10952_AplusB5.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(0 == a) break;
            System.out.println(a + b);
        }
        br.close();
    }
}
