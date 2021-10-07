import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_bj_15900_나무탈출 {

    private static int result;
    private static boolean[] visited;
    private static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_15900_나무탈출.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        list = new ArrayList<>();
        result = 0;

        for (int i = 0; i <= n; ++i) list.add(new ArrayList<>());

        for (int i = 0; i < n - 1; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        dfs(1, 0);

        if(result%2 == 0) System.out.println("No");
        else System.out.println("Yes");

        br.close();
    }

    private static void dfs(int node, int depth) {
        visited[node] = true;

        for(int child : list.get(node)) {
            if(!visited[child]) dfs(child, depth+1);
        }

        if(node != 1 && list.get(node).size() == 1) result += depth;
    }

}