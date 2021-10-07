import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_bj_14676_영우는사기꾼 {
    private static final int BUILD = 1;
    private static final int DESTROY = 2;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_14676_영우는사기꾼.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] build = new int[n + 1];
        int[] inDegree = new int[n + 1];
        List<Integer>[] dependency = new List[n + 1];
        for (int i = 0; i < dependency.length; i++) dependency[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            dependency[x].add(y);
            inDegree[y]++;
        }

        try {
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                int node = Integer.parseInt(st.nextToken());

                if (command == BUILD) {
                    if(0<inDegree[node]) throw new LierException();

                    build[node]++;
                    if(build[node] ==1) for (int d : dependency[node]) inDegree[d]--;

                } else if (command == DESTROY) {
                    if(0>= build[node]) throw new LierException();

                    build[node]--;
                    if(build[node] ==0) for (int d : dependency[node]) inDegree[d]++;
                }
            }

            System.out.println("King-God-Emperor");
        }catch (LierException e){
            System.out.println("Lier!");
        }finally {
            br.close();
        }
    }
}
class LierException extends Exception{}