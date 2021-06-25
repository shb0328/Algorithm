import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bj_11562_백양로브레이크_2 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_11562_백양로브레이크.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Graph graph = new Graph(Integer.parseInt(st.nextToken()));

        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.orgAdj[u][v] = b;
        }

        graph.makeSubGraph();
        graph.subGraph.floyd();

        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (k > cnt++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int rs = graph.subGraph.root[s];
            int re = graph.subGraph.root[e];
            sb.append(graph.subGraph.adj[rs][re]).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }//end of main

    private static class Graph {
        private final int INF = 987654321;

        public int n;
        public int[][] orgAdj;
        public SubGraph subGraph;

        public Graph(int n) {
            super();
            this.n = n;
            init();
        }

        private void init() {
            orgAdj = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    orgAdj[i][j] = INF;
                }
            }
        }

        public void makeSubGraph() {
            this.subGraph = new SubGraph();
        }

        public class SubGraph {
            private int cnt;
            private int[] root;
            private int[][] adj;

            public SubGraph() {
                super();
                init();
            }


            private void init() {
                cnt = 1;
                root = new int[n + 1];
                initRoot();
                adj = new int[cnt][cnt];
                initAdj();
            }


            private void initRoot() {
                Queue<Integer> q = new LinkedList<>();
                for (int i = 1; i <= n; i++) {

                    if(root[i] == 0) {
                        root[i] = cnt++;
                        q.offer(i);
                    }

                    while (!q.isEmpty()) {
                        int node = q.poll();
                        for (int j = 1; j <= n; j++) {
                            if (!(orgAdj[node][j] == 1 || orgAdj[j][node] == 1 )) continue;
                            if(root[j] != 0) continue;
                            root[j] = root[node];
                            q.offer(j);
                        }
                    }
                }
            }

            private void initAdj() {
                for (int i = 1; i < cnt; i++) {
                    for (int j = 1; j < cnt; j++) {
                        if(i == j) continue;
                        adj[i][j] = INF;
                    }
                }

                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        if(orgAdj[i][j] != 0) continue;
                        int u = root[i];
                        int v = root[j];
                        adj[u][v] = 0;
                        if(u == v) continue;
                        if(adj[v][u] == 0) continue;
                        adj[v][u] = 1;
                    }
                }
            }

            public void floyd() {
                for (int x = 1; x < cnt; x++)
                    for (int i = 1; i < cnt; i++)
                        for (int j = 1; j < cnt; j++)
                            adj[i][j] = Math.min(adj[i][j], adj[i][x] + adj[x][j]);
            }

            public void showAdj() {
                System.out.println("##### adj #####");
                for (int i = 1; i < cnt; i++) {
                    System.out.println(Arrays.toString(adj[i]));
                }
            }

            public void showRoot(){
                System.out.println("##### root #####");
                System.out.println(Arrays.toString(root));
            }
        } //end if SubGraph
    } //end if Graph

}
