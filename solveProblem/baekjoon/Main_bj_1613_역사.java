import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_1613_역사 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_1613_역사.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        boolean[][] adj = new boolean[n + 1][n + 1];

        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;
        while (k > cnt++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u][v] = true;
        }
        for (int c = 1; c <= n; c++) {
            for (int i = 1; i <= n; i++) {
                if(!adj[i][c]) continue;
                for (int j = 1; j <= n; j++) {
                    if(adj[c][j]) {
                        adj[i][j] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int s = Integer.parseInt(br.readLine());
        cnt = 0;
        while (s > cnt++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            boolean order = adj[u][v];
            boolean reverse = adj[v][u];

            if(order && !reverse) sb.append(-1);
            else if(!order && reverse) sb.append(1);
            else sb.append(0);
            sb.append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

}
