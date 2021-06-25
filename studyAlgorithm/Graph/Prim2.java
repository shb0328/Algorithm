import java.util.*;

public class Prim2 {

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
    private static PriorityQueue<int[]> pq;

    public static void main(String[] args) {
        System.out.println(prim(4));
    }

    private static int prim(int start) {
        boolean[] visited = new boolean[N];
        visited[start] = true;
        pq = new PriorityQueue<>((int[] o1, int[] o2)->(Integer.compare(o1[1], o2[1])));
        for(int i = 0; i < N; ++i) {
            if(!visited[i] && adj[start][i] != INF) pq.offer(new int[] {i, adj[start][i]});
        }

        int sum = 0;
        int cnt = 0;
        while(!pq.isEmpty()) {
            printPQ();
            int[] current = pq.poll();
            int vertex = current[0];
            int weight = current[1];
            if(!visited[vertex]) {
                visited[vertex] = true;
                sum += weight;
                if(++cnt == N-1) break;
                printEdge(new int[]{vertex,weight});
                for(int i = 0; i < N; ++i) {
                    if(!visited[i] && adj[vertex][i] != INF) pq.offer(new int[] {i,adj[vertex][i]});
                }
            }
        }

        return sum;
    }

    private static void printPQ() {
        StringBuilder sb = new StringBuilder();
        sb.append("Priority Queue : ");
        Iterator<int[]> it = pq.iterator();
        while (it.hasNext()) {
            sb.append(Arrays.toString(it.next()));
        }
        System.out.println(sb.toString());
    }
    private static void printEdge(int[] edge) {
        System.out.println("vertex : " + edge[0]+" , weight : "+edge[1]);
    }
}
