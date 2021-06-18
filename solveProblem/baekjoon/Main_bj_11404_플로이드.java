import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_11404_플로이드 {
    private static int n;
    private static int[][] adj; //adjacency matrix
    private static final int INF = 99999999;


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_11404_플로이드.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        adj = new int[n+1][n+1];
        for (int s = 1; s <= n; s++) {
            for (int e = 1; e <= n; e++) {
                if(s == e) continue;
                adj[s][e] = INF;
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a][b] = Math.min(adj[a][b], c);
        }

        for(int k = 1; k <= n; k++) {
            for(int i=1; i <= n; i++) {
                for(int j=1; j <= n; j++) {
                    if (adj[i][j] > adj[i][k] + adj[k][j])
                        adj[i][j] = adj[i][k] + adj[k][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(adj[i][j] == INF) sb.append("0 ");
                else sb.append(adj[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }

}

