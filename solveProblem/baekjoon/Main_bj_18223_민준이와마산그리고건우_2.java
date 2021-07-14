import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_bj_18223_민준이와마산그리고건우_2 {
    public static final int INF = Integer.MAX_VALUE/2;

    public static int v,e,p;
    public static boolean[] visited;
    public static ArrayList<Node>[] adj;
    public static int[] dist;

    private static class Node implements Comparable<Node> {
        public int vertex;
        public int weight;
        public boolean save;

        public Node(int vertex, int weight) {
            this(vertex, weight, false);
        }

        public Node(int vertex, int weight, boolean save) {
            super();
            this.vertex = vertex;
            this.weight = weight;
            this.save = save;
        }

        @Override
        public int compareTo(Node o) {
            if(this.weight > o.weight) return 1;
            else if(this.weight < o.weight) return -1;
            else {
                if(this.save) return -1;
                else return 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        dijkstra(1, v);
    }

    private static void init() throws IOException {
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_18223_민준이와마산그리고건우.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken()); // vertex
        e = Integer.parseInt(st.nextToken()); // edge
        p = Integer.parseInt(st.nextToken()); // 건우는 민준이와 같은 곳에 있거나 마산에 있을 수도 있다.

        adj = new ArrayList[v+1];
        for (int i = 1; i <= v; i++) adj[i] = new ArrayList<>();

        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }

        dist = new int[v+1];
        Arrays.fill(dist,INF);

        visited = new boolean[v + 1];

        br.close();
    }

    private static void dijkstra(int start, int end) {

        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, dist[start]));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if(current.vertex == p) current.save = true;
            if(current.vertex == end) {
                System.out.println(current.save ? "SAVE HIM" : "GOOD BYE");
                break;
            }

            if(visited[current.vertex]) continue;
            for (Node next : adj[current.vertex]) {
                pq.offer(new Node(next.vertex, current.weight + next.weight, current.save));
                visited[current.vertex] = true;
            }
        }

    }
}
