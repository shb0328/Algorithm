import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_1238_파티 {
    private static final int INF = Integer.MAX_VALUE/2;

    private static int[][] adj;
    private static int N;
    private static int[][] dist;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_1238_파티.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        adj = new int[N + 1][N + 1];
        dist = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        init();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u][v] = w;
            dist[u][v] = w;
        }

        dijkstra(x, -1);
        for (int i = 1; i < dist.length; i++) {
            if(i == x) continue;
            dijkstra(i, x);
        }

        int result = 0;
        for (int i = 1; i < dist.length; i++) {
            if(i == x) continue;
            int roundTrip = dist[i][x] + dist[x][i];
            result = Math.max(roundTrip, result);
        }
        System.out.println(result);

        br.close();
    }

    private static void init() {
        for (int i = 1; i < adj.length; i++) {
            for (int j = 1; j < adj[i].length; j++) {
                adj[i][j] = INF;
                dist[i][j] = INF;
            }
        }
    }

    private static int getSmallIndex(int start) {
        int min = INF;
        int index = 0;
        for (int i = 1; i < dist[start].length; i++) {
            if(visited[i]) continue;
            int d = dist[start][i];
            if(min > d) {
                min = d;
                index = i;
            }
        }
        return index;
    }

    private static void dijkstra(int start, int end) {
        visited = new boolean[N + 1];
        visited[start] = true;

        for (int i = 1; i < N - 1; i++) {
            int current = getSmallIndex(start);
            if(end == current) return;
            visited[current] = true;
            for (int j = 1; j < dist[start].length; j++) {
                if(visited[j]) continue;
                dist[start][j] = Math.min(dist[start][j], dist[start][current] + adj[current][j]);
            }
        }

    }
}
