import java.io.*;
import java.util.StringTokenizer;

public class Main_bj_14501_퇴사 {
    private static int n ;
    private static int[] T ;
    private static int[] P ;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        //input
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_14501_퇴사.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        StringTokenizer st;

        //init
        n = Integer.parseInt(br.readLine());
        T = new int[n];
        P = new int[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = -1;
            str = br.readLine();
            st = new StringTokenizer(str);
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        //solve
        dfs(0);

        //result
        System.out.println(dp[0]);
        br.close();
    }

    private static int dfs(int date) {
        //exit
        if(date > n-1) return 0;
        if(dp[date] != -1) return dp[date];

        //recursive
        if(date + T[date] > n) dp[date] = dfs(date+1);
        else dp[date] = Math.max( dfs(date + T[date])+ P[date], dfs(date+1));

        return dp[date];
    }
}
