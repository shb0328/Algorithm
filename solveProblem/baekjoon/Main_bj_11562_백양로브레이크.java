import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_11562_백양로브레이크 {
    public static void main(String[] args) throws IOException {
        final int INF = 987654321;

        System.setIn(new FileInputStream("solveProblem/res/Main_bj_11562_백양로브레이크.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] adj = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j) continue;
                adj[i][j] = INF;
            }
        }
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[u][v] = 0;
            adj[v][u] = (b == 0) ? 1 : 0;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (k > cnt++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(adj[s][e]).append('\n');
        }

        System.out.println(sb.toString());
    }
}
