import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_4344_평균은넘겠지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] scores = new int[n];
            int sum = 0;
            for(int i = 0; i < n ; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
                sum += scores[i];
            }

            float avg = sum/n;
            int cnt = 0;
            for(int score : scores) if(score > avg) cnt++;
            float rate = (float)cnt/(float)n *100;
            System.out.println(String.format("%.3f",rate) +"%");
        }
        br.close();
    }
}
