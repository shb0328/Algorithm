import java.io.*;
import java.util.StringTokenizer;

public class Main_bj_11022_AplusB8 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_11022_AplusB8.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write("Case #"+i+": "+ a + " + " + b + " = " + (a+b) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
