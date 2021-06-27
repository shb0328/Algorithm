import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bj_3665_최종순위 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_3665_최종순위.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            boolean[] ck = new boolean[n + 1];
            boolean[][] graph = new boolean[n + 1][n + 1];
            int[] teams = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < teams.length; ++i) {
                int t = Integer.parseInt(st.nextToken());
                teams[i] = t;
                ck[t] = true;
                for (int j = 1; j < graph.length; j++) {
                    if(ck[j]) continue;
                    graph[j][t] = true;
                }
            }

            int m = Integer.parseInt(br.readLine());
            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(graph[a][b]) graph[a][b] = false;
                else graph[a][b] = true;
                if(graph[b][a]) graph[b][a] = false;
                else graph[b][a] = true;
            }

            Queue<Integer> q = new LinkedList<>();
            int[] entryLevel = new int[n + 1];
            for (int i = 1; i < graph.length; i++) {
                for (int j = 1; j < graph[i].length; j++) {
                    if(graph[i][j])  entryLevel[i]++;
                }
            }

            for (int i = 1; i < entryLevel.length; i++) {
                if(entryLevel[i] == 0) q.offer(i);
            }

            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            while (cnt < n) {
                if(q.isEmpty()) {
                    sb = new StringBuilder("IMPOSSIBLE");
                    break;
                }

                if(q.size() > 1) {
                    sb = new StringBuilder("?");
                    break;
                }

                cnt++;
                int team = q.poll();
                sb.append(team).append(' ');

                for (int i = 1; i < graph.length; i++) {
                    if(graph[i][team] && entryLevel[i] == cnt) q.offer(i);
                }
            }
            System.out.println(sb.toString());

        }// end of while (tc)

        br.close();
    }

    private static void printGraph(boolean[][] graph) {
        System.out.println("================== graph =================");
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph[i].length; j++) {
                if(graph[i][j]) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
        System.out.println("==========================================");
    }

}
