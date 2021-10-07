import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_1253_좋다 {
    private static int n;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_1253_좋다.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int result = 0;
        for (int idx = 0; idx < n; idx++) {
            if(isGood(idx)) result++;
        }

        System.out.println(result);
        br.close();
    }

    private static boolean isGood(int idx) {
        int lo = 0, hi = n-1;
        int num = arr[idx];

        while (lo < hi) {
            if(lo == idx) lo++;
            else if(hi == idx) hi--;

            int sum = arr[lo] + arr[hi];

            if(sum == num) return true;
            else if(sum > num) hi--;
            else if(sum < num) lo++;
        }
        return false;
    }
}
