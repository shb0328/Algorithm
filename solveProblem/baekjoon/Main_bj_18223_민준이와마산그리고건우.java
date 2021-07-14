import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_bj_18223_민준이와마산그리고건우 {
    public static final int INF = Integer.MAX_VALUE/2;

    public static int v,e, GUNWOO;
    public static boolean[] visited;
    public static ArrayList<int[]>[] adj;
    public static int[] pToMinjune, pToMasan, minjuneToMasan;
    public static int MINJUNE, MASAN;

    public static void main(String[] args) throws IOException {

        input();

        init();

        dijkstra(GUNWOO, MINJUNE, pToMinjune);
        dijkstra(GUNWOO, MASAN, pToMasan);
        dijkstra(MINJUNE, MASAN, minjuneToMasan);

        System.out.println(isSavedHim() ? "SAVE HIM" : "GOOD BYE");
    }

    private static void input() throws IOException {
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_18223_민준이와마산그리고건우.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken()); // vertex
        e = Integer.parseInt(st.nextToken()); // edge
        GUNWOO = Integer.parseInt(st.nextToken()); // 건우는 민준이와 같은 곳에 있거나 마산에 있을 수도 있다.

        adj = new ArrayList[v+1];
        for (int i = 1; i <= v; i++) adj[i] = new ArrayList<>();

        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new int[]{b, c});
            adj[b].add(new int[]{a, c});
        }

        br.close();
    }

    private static void init() {
        MINJUNE = 1;
        MASAN = v;

        pToMinjune = new int[v+1];
        pToMasan = new int[v+1];
        minjuneToMasan = new int[v+1];

        Arrays.fill(pToMinjune,INF);
        Arrays.fill(pToMasan,INF);
        Arrays.fill(minjuneToMasan,INF);
    }

    private static void dijkstra(int start, int end, int[] dist) {
        visited = new boolean[v + 1];
        visited[start] = true;

        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2) -> (Integer.compare(o1[1], o2[1])));
        pq.offer(new int[]{start, dist[start]});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int current = node[0];
            int d = node[1];
            if(current == end) break;

            visited[current] = true;
            for (int[] nextNode : adj[current]) {
                int next = nextNode[0];
                int w = nextNode[1];
                if(visited[next]) continue;
                if (dist[next] > w + d) {
                    dist[next] = w + d;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }
    }

    private static boolean isSavedHim() {  return pToMinjune[MINJUNE] + pToMasan[MASAN] == minjuneToMasan[MASAN]; }

}
