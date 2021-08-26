import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_bj_1316_그룹단어체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int answer = tc;
        while (tc-- > 0) {
            boolean[] ck = new boolean['z'+1];
            char[] arr = br.readLine().toCharArray();
            char prev = 0;
            for (char c : arr) {
                if(ck[c]) {answer--;break;}
                if(prev == c) continue;
                ck[prev] = true;
                prev = c;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
