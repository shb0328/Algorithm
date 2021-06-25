import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_bj_2887_행성터널 {
    private static int n;
    private static PriorityQueue<int[]> pqX;
    private static PriorityQueue<int[]> pqY;
    private static PriorityQueue<int[]> pqZ;
    private static PriorityQueue<int[]> pq;
    private static int[] p;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_2887_행성터널.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        pqX = new PriorityQueue<>((int[] o1, int[] o2) -> (Integer.compare(o1[1], o2[1])));
        pqY = new PriorityQueue<>((int[] o1, int[] o2) -> (Integer.compare(o1[1], o2[1])));
        pqZ = new PriorityQueue<>((int[] o1, int[] o2) -> (Integer.compare(o1[1], o2[1])));
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pqX.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            pqY.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            pqZ.offer(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        System.out.println(kruskal());

        br.close();
    }

    private static int kruskal() {
        p = new int[n];
        makeSet();

        pq = new PriorityQueue<>((int[] o1, int[] o2) -> (Integer.compare(o1[2], o2[2])));
        initPQ();

        int sum = 0;
        int cnt = 0;
        while (!pq.isEmpty()){
            int[] edge = pq.poll();
            if(isCycle(edge)) continue;
            sum += edge[2];
            union(edge[0], edge[1]);
            if(cnt++ == n-1) break;
        }

        return sum;
    }

    private static boolean isCycle(int[] edge) {
        return find(edge[0]) == find(edge[1]);
    }

    private static void initPQ() {
        int[] current = pqX.poll();
        while (!pqX.isEmpty()) {
            int[] next = pqX.poll();
            pq.offer(new int[]{current[0], next[0], Math.abs(current[1] - next[1])});
            current = next;
        }

        current = pqY.poll();
        while (!pqY.isEmpty()) {
            int[] next = pqY.poll();
            pq.offer(new int[]{current[0], next[0], Math.abs(current[1] - next[1])});
            current = next;
        }

        current = pqZ.poll();
        while (!pqZ.isEmpty()) {
            int[] next = pqZ.poll();
            pq.offer(new int[]{current[0], next[0], Math.abs(current[1] - next[1])});
            current = next;
        }
    }

    private static void makeSet() {
        for(int i = 0; i < n; i++) p[i] = i;
    }

    private static int find(int x) {
        if(p[x] == x) return x;
        return p[x] = find(p[x]);
    }

    private static int union(int x, int y) {
        return p[find(y)] = find(x);
    }


}
