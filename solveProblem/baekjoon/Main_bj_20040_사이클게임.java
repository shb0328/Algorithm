import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_20040_사이클게임 {
    private static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        p = new int[n];
        for(int i = 0; i < n; i++) p[i] = i;

        for(int turn = 1; turn <= m; turn++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            if(!union(p1,p2)) {
                System.out.println(turn);
                return;
            }
        }
        System.out.println(0);
        br.close();
    }

    private static int find(int x) {
        if(p[x] == x) return x;
        return p[x] = find(p[x]);
    }

    private static boolean union(int x1, int x2) {
        x1 = find(x1);
        x2 = find(x2);

        if(x1 == x2) return false;

        if(x1 > x2 ) p[x1] = x2;
        else p[x2] = x1;
        return true;
    }
}
