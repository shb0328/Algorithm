import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_bj_8958_OX퀴즈 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_8958_OX퀴즈.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0) {
            int cnt = 0, sum = 0;
            char[] ans = br.readLine().toCharArray();
            for(char c : ans) sum += (c == 'X') ? (cnt = 0) : ++cnt;
            sb.append(sum).append('\n');
        }
        System.out.println(sb.toString());
        br.close();
    }
}
