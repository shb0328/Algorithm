
import java.util.*;

public class Kruskal {

    public static int INF = Integer.MAX_VALUE/2;
    public static int N = 6;
    public static int[][] adj = {
            // A, B, C, D, S, T
/*A*/     {   0,  6, 3,INF, 7, INF},
/*B*/     {   6,  0, 4, 2, INF, 5},
/*C*/     {   3,  4, 0, 3,  8, INF},
/*D*/     { INF,  2, 3, 0, INF, 2},
/*S*/     {   7,INF, 8,INF, 0, INF},
/*T*/     { INF,  5,INF,2, INF,  0}
    };

    public static void main(String[] args) {
        System.out.println(kruskal(0));
    }

    /**
     *  union find
     */
    public static int[] p;

    public static int findSet(int x) {
        if(x==p[x]) return x;
        else return p[x] = findSet(p[x]);
    }
    public static void union(int x, int y) {
        p[findSet(y)] = findSet(x);
    }

    /**
     * kruskal
     */
    private static int kruskal(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2)->(Integer.compare(o1[2], o2[2])));
        initPQ(pq);

        p = new int[N];
        makeSet();

        int sum = 0;
        int cnt = 0;
        while(!pq.isEmpty()) {
            int[] edge = pq.poll();
            if(isCycle(edge)) continue;
            printEdge(edge);
            sum += edge[2];
            if(++cnt == N-1) break;
            union(edge[0], edge[1]);
        }

        return sum;
    }

    private static boolean isCycle(int[] edge) {
        return findSet(edge[0]) == findSet(edge[1]);
    }

    private static void printEdge(int[] edge) {
        System.out.println(edge[0]+" - "+edge[1]+" , weight : "+edge[2]);
    }

    private static void initPQ(PriorityQueue<int[]> pq) {
        for(int i = 0; i < N-1; ++i) {
            for(int j = i+1; j < N; ++j) { // undirected Graph 이므로 절반만 offer
                if(adj[i][j]!=INF) pq.offer(new int[] {i,j, adj[i][j]});  // i - j, weight
            }
        }
    }

    private static void makeSet() {
        for(int i = 0; i < N; ++i) p[i] = i;
    }
}