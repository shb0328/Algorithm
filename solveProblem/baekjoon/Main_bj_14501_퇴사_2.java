import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main_bj_14501_퇴사_V2 {
    private static int n;
    private static int[] t;
    private static int[] p;
    private static int[] da; //dp array

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("solveProblem/res/Main_bj_14501_퇴사.txt"));
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        t = new int[n];
        p = new int[n];
        da = new int[n];

        for (int i = 0; i < n; ++i) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
            da[i] = -1; //init;
        }

        dp(0);

        System.out.println(da[0]);
        sc.close();
    }

    private static int dp(int day) {//da 배열 채우기
        if(day > n) return -5999;
        if(day == n) return 0;
        if(da[day] < 0) return da[day] = Math.max(dp(day+t[day])+p[day],dp(day+1)); //day를 선택하거나 안하고 다음날로 넘어가거나
        else return da[day]; //이미 d가 구해져 있다면, day을 선택했을 때, 그 후로 선택할 수 있는 모든 경우에 대해 최댓값이 구해져 있는 것
    }
}