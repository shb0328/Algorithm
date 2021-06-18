import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_18353_병사배치하기 {
    public static void main(String[] args) throws IOException {
        // input
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_18353_병사배치하기.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // init
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        int[] soldiers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            soldiers[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        // solve (LIS)
        for (int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(soldiers[i] < soldiers[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        // result
        Arrays.sort(dp);
        System.out.println(n - dp[n-1]);
    }
}
