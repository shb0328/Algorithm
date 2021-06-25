import java.util.*;

public class Prim1 {

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
    private static int[] w;

    public static void main(String[] args) {
        System.out.println(prim(4));
    }

    private static int prim(int start) {
        w = new int[N];
        Arrays.fill(w, -1);
        w[start] = 0;

        for(int k = 0; k < N-1; ++k) {
            int minWeight = INF;
            int minVertax = 0;
            for(int i = 0; i < N; ++i) {
                if( w[i] < 0 ) continue;
                for(int j = 0; j < N; ++j) {
                    if( isVisited(j) ) continue;
                    if( minWeight > adj[i][j] ) {
                        minWeight = adj[i][j];
                        minVertax = j; // 최단 i->j
                        printEdge(new int[]{i,j, adj[i][j]});
                    }
                }
            }
            w[minVertax] = minWeight;
            printArrayW();
        }

        int sum = 0;

        for ( int i = 0; i < N; ++i)
            sum += w[i];

        return sum;
    }

    private static boolean isVisited(int idx) {
        return w[idx] >= 0;
    }
    private static void printEdge(int[] edge) {
        System.out.println(edge[0]+" - "+edge[1]+" , weight : "+edge[2]);
    }
    private static void printArrayW() {
        System.out.println("w : "+Arrays.toString(w));
    }
}
