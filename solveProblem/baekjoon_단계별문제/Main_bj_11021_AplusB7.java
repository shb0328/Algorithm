import java.io.*;
import java.util.StringTokenizer;

public class Main_bj_11021_AplusB7 {
    public static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_11021_AplusB7.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 1; i <= tc; i++){
            st = new StringTokenizer(br.readLine());
            bw.write("Case #" + i + ": " + Integer.toString(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + NEW_LINE);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
