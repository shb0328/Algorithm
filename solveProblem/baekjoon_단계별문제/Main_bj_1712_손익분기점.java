import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_1712_손익분기점 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = -1;
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        // A+(B*X) < C*X 최소 X (자연수)
        // A < (C-B)*X
        // A/(C-B) < X
        // C-B <= 0 이면 X를 구할 수 없다.

        int profit = C-B;
        if(profit > 0) answer = A/profit+1;
        System.out.println(answer);
        br.close();
    }
}
