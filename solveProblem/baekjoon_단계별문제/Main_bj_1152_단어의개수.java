import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_bj_1152_단어의개수 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine().trim();
//        int answer = str.length() == 0 ? 0 : str.split(" ").length;
//        System.out.println(answer);
//        br.close();

        //System.in.read()
        int cnt = 0;
        int pre = ' ';
        while (true) {
            int ch = System.in.read();
            if(ch == '\n') {
                if(pre != ' ') cnt++;
                break;
            }
            if(ch == ' ') {
                if(pre != ' ') cnt++;
            }
            pre = ch;
        }
        System.out.println(cnt);
    }
}
