import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str; StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        String Answer;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; ++tc) {
            //init
            Answer = "answer";

            //input
            str = br.readLine();
            st = new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken());

            for(int i = 0; i < n; ++i) {
                str = br.readLine();
                st = new StringTokenizer(str);
                int v = Integer.parseInt(st.nextToken());
            }

            //solve
            solve();

            //result
            sb.append(Answer).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    private static void solve() {
        //TODO
    }
}
