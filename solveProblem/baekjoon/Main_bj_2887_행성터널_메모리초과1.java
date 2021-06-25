import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_bj_2887_행성터널_메모리초과1 {
    private static int n;
    private static int[][] planetList;
    private static int[] p;
    private static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_2887_행성터널.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        planetList = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            planetList[i][0] = Integer.parseInt(st.nextToken());
            planetList[i][1] = Integer.parseInt(st.nextToken());
            planetList[i][2] = Integer.parseInt(st.nextToken());
        }

        System.out.println(kruskal());

        br.close();
    }

    private static int kruskal() {
        p = new int[n];
        makeSet();

        pq = new PriorityQueue<>((int[] o1, int[] o2)->(Integer.compare(o1[2], o2[2])));
        initPQ();

        int sum = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            if(find(edge[0]) == find(edge[1])) continue;
            union(edge[0], edge[1]);
            sum += edge[2];
            if(cnt++ == n-1) break;
        }
        return sum;
    }

    private static void makeSet() {
        for (int i = 0; i < n; i++) p[i] = i;
    }

    private static void initPQ() {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int minWeight = Math.min(Math.abs(planetList[i][0] - planetList[j][0]), Math.abs(planetList[i][1] - planetList[j][1]));
                minWeight = Math.min(minWeight, Math.abs(planetList[i][2] - planetList[j][2]));
                pq.offer(new int[]{i, j, minWeight});
            }
        }
    }

    private static int find(int x) {
        if(p[x] == x) return x;
        return p[x] = find(p[x]);
    }

    private static int union(int x, int y) {
        return p[find(y)] = find(x);
    }

}
