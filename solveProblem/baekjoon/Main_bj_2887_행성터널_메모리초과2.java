import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_bj_2887_행성터널_메모리초과2 {
    private static int n;
    private static int[][] planetList;
    private static PriorityQueue<int[]> pq;
    private static boolean[] visited;

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

        System.out.println(prim());

        br.close();
    }

    private static int prim() {
        int start = 0;
        visited = new boolean[n];
        visited[start] = true;

        pq = new PriorityQueue<>((int[] o1, int[] o2) -> (Integer.compare(o1[1], o2[1])));
        nextVertex(start);

        int sum = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int vertex = current[0];
            int weight = current[1];
            if(visited[vertex]) continue;
            visited[vertex] = true;
            sum += weight;
            if(cnt++ == n-1) break;
            nextVertex(vertex);
        }
        return sum;
    }

    private static void nextVertex(int i) {
        for (int j = 0; j < n; j++) {
            if(visited[j]) continue;
            int minWeight = Math.min(Math.abs(planetList[i][0] - planetList[j][0]), Math.abs(planetList[i][1] - planetList[j][1]));
            minWeight = Math.min(minWeight, Math.abs(planetList[i][2] - planetList[j][2]));
            pq.offer(new int[]{j, minWeight});
        }
    }

}
