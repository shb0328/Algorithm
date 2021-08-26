import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_2675_문자열반복 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            char[] str = st.nextToken().toCharArray();
            for(char c : str)
                for(int i = 0; i < cnt; ++i)
                    sb.append(c);
            sb.append('\n');
        }
        System.out.println(sb.toString());
        br.close();
    }
}
