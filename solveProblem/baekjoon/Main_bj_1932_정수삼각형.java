import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_1932_정수삼각형 {
    public static void main(String[] args) throws IOException {
        //input
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_1932_정수삼각형.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        StringTokenizer st;

        //init
        int n = Integer.parseInt(br.readLine());
        int[][] data = new int[n][];

        for (int i = 0; i < n; i++) {
            data[i] = new int[i + 1];

            str = br.readLine();
            st = new StringTokenizer(str);

            int idx = 0;
            while (st.hasMoreTokens()) data[i][idx++] = Integer.parseInt(st.nextToken());
        }

        int[] dp = data[n-1].clone();

        //solve
        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j < data[i].length; j++) {
                dp[j] = Math.max(dp[j] + data[i][j], dp[j+1] + data[i][j]);
            }
//            System.out.println("dp : "+Arrays.toString(dp));
        }

        //result
        System.out.println(dp[0]);
        br.close();
    }
}
