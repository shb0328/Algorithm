import java.util.Scanner;

public class Main_bj_2884_알람시계 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt() + 24;
        int m = sc.nextInt();
        int time = h * 60 + m - 45;
        System.out.println(time / 60 % 24 + " " + time % 60);
        sc.close();
    }
}
