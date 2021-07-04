import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_bj_1261_알고스팟_2 {
    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0,1,0,-1};
    private static char[][] map;
    private static boolean[][] visited;
    private static int n,m;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_1261_알고스팟.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[m][n];
        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs(0, 0));

        br.close();
    }

    private static int bfs(int x, int y) {
        Deque<int[]> dq = new ArrayDeque<>();

        dq.offer(new int[]{x, y, 0});
        visited[y][x] = true;

        int nx,ny;
        while (!dq.isEmpty()) {
            int[] pos = dq.poll();

            if(isArrived(pos[0], pos[1])) return pos[2];

            for (int d = 0; d < 4; d++) {
                nx = pos[0] + dx[d];
                ny = pos[1] + dy[d];

                if (!isRange(nx, ny)) continue;
                if(visited[ny][nx]) continue;

                visited[ny][nx] = true;
                if(map[ny][nx] == '0') dq.offerFirst(new int[]{nx,ny,pos[2]});
                else dq.offerLast(new int[]{nx, ny, pos[2] + 1});

            }
        }
        return 0;
    }

    private static boolean isArrived(int x, int y) {
        return x == (n-1) && y == (m-1);
    }

    private static boolean isRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

}
