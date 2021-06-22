import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_1507_궁금한민호 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_1507_궁금한민호.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] adj = new int[n + 1][n + 1];
        boolean[][] needK = new boolean[n + 1][n + 1];

        StringTokenizer st;
        for (int i = 1; i <= n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; ++j) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = i+1; j <= n ; j++) {
                    if(k == i || k == j) continue;
                    int value = adj[i][j];
                    if(value > adj[i][k] + adj[k][j]) {
                        System.out.println(-1);
                        return;
                    }
                    if(value  == adj[i][k] + adj[k][j]) needK[i][j] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n ; j++) {
                if(!needK[i][j]) answer += adj[i][j];
            }
        }

        System.out.println(answer);
        br.close();
    }
}
