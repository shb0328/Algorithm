import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_bj_3052_나머지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] ck = new boolean[42];
        int cnt = 11;
        while (--cnt > 0) ck[Integer.parseInt(br.readLine()) % 42] = true;
        for(boolean isTrue : ck) if(isTrue) cnt++;
        System.out.println(cnt);
        br.close();
    }
}
